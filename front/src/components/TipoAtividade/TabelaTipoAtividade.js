import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { FiEdit, FiTrash2 } from 'react-icons/fi';
import '../../styles/tabela.css';
import ModalTipoAtividade from './ModalTipoAtividade';

const TabelaTipoAtividade = () => {
  const [tiposAtividade, setTiposAtividade] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [tipoAtividadeSelecionado, setTipoAtividadeSelecionado] = useState(null);
  const [erro, setErro] = useState('');

  const handleAlterarClick = (tipoAtividade) => {
    setTipoAtividadeSelecionado(tipoAtividade);
    setShowModal(true);
  };

  const Erro = ({ mensagem }) => {
    return <div className="mensagem-erro">{mensagem}</div>;
  };

  const handleAlterarSubmit = () => {
    // Fechar o modal
    setShowModal(false);
    fetchTiposAtividade();
  };

  const fetchTiposAtividade = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/tipoatividade');
      setTiposAtividade(response.data);
    } catch (error) {
      console.error('Erro ao buscar os dados dos tipos de atividade:', error);
      // Tratar o erro de acordo com as necessidades do seu aplicativo
    }
  };

  const deletaTipoAtividade = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/tipoatividade/${id}`);
      setErro('Tipo de atividade deletado com sucesso.');
      fetchTiposAtividade();
    } catch (error) {
      setErro('Erro ao deletar o tipo de atividade. Por favor, tente novamente.');
      // Tratar o erro de acordo com as necessidades do seu aplicativo
    }
  };

  useEffect(() => {
    // Função para buscar os dados dos tipos de atividade
    fetchTiposAtividade();
  }, []);

  return (
    <>
      {erro && <Erro mensagem={erro} />}
      <br></br>
      <table>
        <thead>
          <tr>
            <th>Nome</th>
            <th>Status</th>
            <th>Excluir</th>
            <th>Alterar</th>
          </tr>
        </thead>
        <tbody>
          {tiposAtividade.map((tipoAtividade) => (
            <tr key={tipoAtividade.id}>
              <td>{tipoAtividade.nome}</td>
              <td>{tipoAtividade.status ? 'Ativo' : 'Inativo'}</td>
              <td>
                <button className="btn-excluir" onClick={() => deletaTipoAtividade(tipoAtividade.id)}>
                  <FiTrash2 size={20} color="#FF0000" />
                </button>
              </td>
              <td>
                <button className="btn-editar" onClick={() => handleAlterarClick(tipoAtividade)}>
                  <FiEdit size={20} color="#00FF00" />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {showModal && tipoAtividadeSelecionado && (
        <ModalTipoAtividade
          tipoAtividade={tipoAtividadeSelecionado}
          onClose={() => setShowModal(false)}
          onSubmit={handleAlterarSubmit}
        />
      )}
    </>
  );
};

export default TabelaTipoAtividade;
