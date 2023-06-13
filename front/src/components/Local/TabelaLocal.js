import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { FiEdit, FiTrash2 } from 'react-icons/fi';
import '../../styles/tabela.css';
import ModalLocal from './ModalLocal';

const TabelaLocal = () => {
  const [locais, setLocais] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [localSelecionado, setLocalSelecionado] = useState(null);
  const [erro, setErro] = useState('');

  const handleAlterarClick = (local) => {
    setLocalSelecionado(local);
    setShowModal(true);
  };

  const Erro = ({ mensagem, sucesso }) => {
    const estilo = sucesso ? 'mensagem-sucesso' : 'mensagem-fracasso';
    return <div className={estilo}>{mensagem}</div>;
  };

  const handleAlterarSubmit = (dadosLocal) => {
    // Fechar o modal
    fetchLocais();
    setShowModal(false);
  };

  const fetchLocais = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/local');
      setLocais(response.data);
    } catch (error) {
      console.error('Erro ao buscar os dados dos locais:', error);
      // Tratar o erro de acordo com as necessidades do seu aplicativo
    }
  };

  const deletaLocal = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/local/${id}`);
      setErro({ mensagem: 'Local deletado com sucesso.', sucesso: true });
      fetchLocais();
    } catch (error) {
      setErro({ mensagem: 'Erro ao deletar o local. Por favor, tente novamente.', sucesso: false });
      // Tratar o erro de acordo com as necessidades do seu aplicativo
    }
  };

  useEffect(() => {
    // Função para buscar os dados dos locais
    fetchLocais();
  }, []);

  return (
    <>
      {erro && <Erro mensagem={erro.mensagem} sucesso={erro.sucesso} />}
      <br />
      <table>
        <thead>
          <tr>
            <th>Nome</th>
            <th>Endereço</th>
            <th>Telefone</th>
            <th>Bairro</th>
            <th>CEP</th>
            <th>Excluir</th>
            <th>Alterar</th>
          </tr>
        </thead>
        <tbody>
          {locais.map((local) => (
            <tr key={local.id}>
              <td>{local.nome}</td>
              <td>{local.endereco}</td>
              <td>{local.telefone}</td>
              <td>{local.bairro}</td>
              <td>{local.cep}</td>
              <td>
                <button className="btn-excluir" onClick={() => deletaLocal(local.id)}>
                  <FiTrash2 size={20} color="#FF0000" />
                </button>
              </td>
              <td>
                <button className="btn-editar" onClick={() => handleAlterarClick(local)}>
                  <FiEdit size={20} color="#00FF00" />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {showModal && localSelecionado && (
        <ModalLocal
          local={localSelecionado}
          onClose={() => setShowModal(false)}
          onSubmit={handleAlterarSubmit}
        />
      )}
    </>
  );
};

export default TabelaLocal;
