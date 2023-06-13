import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { FiEdit, FiTrash2 } from 'react-icons/fi';
import '../../styles/tabela.css';
import ModalPastoral from './ModalPastoral';

const TabelaPastorais = () => {
  const [pastorais, setPastorais] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [pastoralSelecionada, setPastoralSelecionada] = useState(null);
  const [erro, setErro] = useState('');

  const handleAlterarClick = (pastoral) => {
    setPastoralSelecionada(pastoral);
    setShowModal(true);
  };

  const Erro = ({ mensagem, sucesso }) => {
    const estilo = sucesso ? 'mensagem-sucesso' : 'mensagem-fracasso';
    return <div className={estilo}>{mensagem}</div>;
  };

  const handleAlterarSubmit = (dadosPastoral) => {
    // Fechar o modal
    fetchPastorais();
    setShowModal(false);
  };

  const fetchPastorais = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/pastoral');
      setPastorais(response.data);
    } catch (error) {
      console.error('Erro ao buscar os dados das pastorais:', error);
      setErro({ mensagem: 'Erro ao buscar as pastorais. Por favor, tente novamente.', sucesso: false });
    }
  };

  const deletaPastoral = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/pastoral/${id}`);
      setErro({ mensagem: 'Pastoral deletada com sucesso.', sucesso: true });
      fetchPastorais();
    } catch (error) {
      setErro({ mensagem: 'Erro ao deletar a pastoral. Por favor, tente novamente.', sucesso: false });
      console.error('Erro ao deletar a pastoral:', error);
    }
  };

  useEffect(() => {
    fetchPastorais();
  }, []);

  return (
    <>
      {erro && <Erro mensagem={erro.mensagem} sucesso={erro.sucesso} />}
      <br />
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome da Pastoral</th>
            <th>Descrição</th>
            <th>Coordenador</th>
            <th>Data de Criação</th>
            <th>Data de Encerramento</th>
            <th>Excluir</th>
            <th>Alterar</th>
          </tr>
        </thead>
        <tbody>
          {pastorais.map((pastoral) => (
            <tr key={pastoral.id}>
              <td>{pastoral.id}</td>
              <td>{pastoral.nomepastoral}</td>
              <td>{pastoral.descricaopastoral}</td>
              <td>{pastoral.coordenador.nome}</td>
              <td>{pastoral.datacriacao}</td>
              <td>{pastoral.dataencerramento}</td>
              <td>
                <button className="btn-excluir" onClick={() => deletaPastoral(pastoral.id)}>
                  <FiTrash2 size={20} color="#FF0000" />
                </button>
              </td>
              <td>
                <button className="btn-editar" onClick={() => handleAlterarClick(pastoral)}>
                  <FiEdit size={20} color="#00FF00" />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {showModal && pastoralSelecionada && (
        <ModalPastoral
          pastoral={pastoralSelecionada}
          onClose={() => setShowModal(false)}
          onSubmit={handleAlterarSubmit}
        />
      )}
    </>
  );
};

export default TabelaPastorais;
