import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { FiEdit, FiTrash2 } from 'react-icons/fi';
import '../../styles/tabela.css';
import ModalParoquiano from './ModalParoquiano';

const TabelaParoquianos = () => {
  const [paroquianos, setParoquianos] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [paroquianoSelecionado, setParoquianoSelecionado] = useState(null);
  const [erro, setErro] = useState('');

  const handleAlterarClick = (paroquiano) => {
    setParoquianoSelecionado(paroquiano);
    setShowModal(true);
  };

  const Erro = ({ mensagem, sucesso }) => {
    const estilo = sucesso ? 'mensagem-sucesso' : 'mensagem-fracasso';
    return <div className={estilo}>{mensagem}</div>;
  };

  const handleAlterarSubmit = (dadosParoquiano) => {
    // Fechar o modal
    fetchParoquianos();
    setShowModal(false);
  };
  
  const fetchParoquianos = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/paroquiano');
      setParoquianos(response.data);
    } catch (error) {
      console.error('Erro ao buscar os dados dos paroquianos:', error);
      // Tratar o erro de acordo com as necessidades do seu aplicativo
    }
  };

  const deletaParoquiano = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/paroquiano/${id}`);
      setErro({ mensagem: 'Paroquiano deletado com sucesso.', sucesso: true });
      fetchParoquianos();
    } catch (error) {
      setErro({ mensagem: 'Erro ao deletar o paroquiano. Por favor, tente novamente.', sucesso: false });
      // Tratar o erro de acordo com as necessidades do seu aplicativo
    }
  };

  useEffect(() => {
    // Função para buscar os dados dos paroquianos

    // Chamar a função de busca dos paroquianos
    fetchParoquianos();
  }, []);

  return (
    <>
      {erro && <Erro mensagem={erro.mensagem} sucesso={erro.sucesso} />}
      <br></br>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Foto</th>
            <th>Telefone</th>
            <th>Email</th>
            <th>Senha</th>
            <th>Excluir</th>
            <th>Alterar</th>
          </tr>
        </thead>
        <tbody>
          {paroquianos.map((paroquiano) => (
            <tr key={paroquiano.id}>
              <td>{paroquiano.id}</td>
              <td>{paroquiano.nome}</td>
              <td>{paroquiano.foto}</td>
              <td>{paroquiano.telefone}</td>
              <td>{paroquiano.email}</td>
              <td>{paroquiano.senha}</td>
              <td>
                <button className="btn-excluir" onClick={() => deletaParoquiano(paroquiano.id)}>
                  <FiTrash2 size={20} color="#FF0000" />
                </button>
              </td>
              <td>
                <button className="btn-editar" onClick={() => handleAlterarClick(paroquiano)}>
                  <FiEdit size={20} color="#00FF00" />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {showModal && paroquianoSelecionado && (
        <ModalParoquiano
          paroquiano={paroquianoSelecionado}
          onClose={() => setShowModal(false)}
          onSubmit={handleAlterarSubmit}
        />
      )}
    </>
  );
};

export default TabelaParoquianos;
