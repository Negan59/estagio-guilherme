import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { FiEdit, FiTrash2 } from 'react-icons/fi';
import '../styles/tabela.css';
import ModalSala from './ModalSala';

const TabelaSalas = () => {
  const [salas, setSalas] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [salaSelecionada, setSalaSelecionada] = useState(null);
  const [erro, setErro] = useState('');

  const handleAlterarClick = (sala) => {
    setSalaSelecionada(sala);
    setShowModal(true);
  };

  const Erro = ({ mensagem, sucesso }) => {
    const estilo = sucesso ? 'mensagem-sucesso' : 'mensagem-fracasso';
    return <div className={estilo}>{mensagem}</div>;
  };

  const handleAlterarSubmit = (dadosSala) => {
    // Fechar o modal
    fetchSalas()
    setShowModal(false);
  };
  const fetchSalas = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/sala');
      setSalas(response.data);
    } catch (error) {
      console.error('Erro ao buscar os dados das salas:', error);
      // Tratar o erro de acordo com as necessidades do seu aplicativo
    }
  }

  const deletaSala = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/sala/${id}`);
      setErro({ mensagem: 'Sala deletada com sucesso.', sucesso: true });
      fetchSalas();
    } catch (error) {
      setErro({ mensagem: 'Erro ao deletar a sala. Por favor, tente novamente.', sucesso: false });
      // Tratar o erro de acordo com as necessidades do seu aplicativo
    }
  };
  useEffect(() => {
    // Função para buscar os dados das salas
    

    // Chamar a função de busca das salas
    fetchSalas();
  }, []);

  return (
    <>
      {erro && <Erro mensagem={erro.mensagem} sucesso={erro.sucesso} />}
      <br></br>
      <table>
        <thead>
          <tr>
            <th>Número da sala</th>
            <th>Descrição</th>
            <th>Excluir</th>
            <th>Alterar</th>
          </tr>
        </thead>
        <tbody>
          {salas.map((sala) => (
            <tr key={sala.id}>
              <td>{sala.numerosala}</td>
              <td>{sala.descricaosala}</td>
              <td>
                <button className="btn-editar" onClick={() => handleAlterarClick(sala)}>
                  <FiEdit size={20} color="#00FF00" />
                </button>
              </td>
              <td>
                <button className="btn-excluir" onClick={()=>deletaSala(sala.id)}>
                  <FiTrash2 size={20} color="#FF0000" />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {showModal && salaSelecionada && (
        <ModalSala
          sala={salaSelecionada}
          onClose={() => setShowModal(false)}
          onSubmit={handleAlterarSubmit}
        />
      )}
    </>
  );
};

export default TabelaSalas;