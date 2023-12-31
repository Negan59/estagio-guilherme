import React, { useState, useEffect } from 'react';
import ModalChave from './ModalChave';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Table, Button } from 'react-bootstrap';
import '../../styles/tabela.css';

const TabelaChave = () => {
  const [chaves, setChaves] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [chaveSelecionada, setChaveSelecionada] = useState(null);
  const [erro, setErro] = useState('');

  const handleAlterarClick = (chave) => {
    setChaveSelecionada(chave);
    setShowModal(true);
  };

  const Erro = ({ mensagem, sucesso }) => {
    const estilo = sucesso ? 'alert alert-success' : 'alert alert-danger';
    return <div className={estilo}>{mensagem}</div>;
  };

  const handleAlterarSubmit = (dadosChave) => {
    // Fechar o modal
    fetchChaves();
    setShowModal(false);
  };

  const fetchChaves = () => {
    fetch('http://localhost:8080/api/chave')
      .then((response) => response.json())
      .then((data) => {
        console.log(data)
        setChaves(data);
      })
      .catch((error) => {
        console.error('Erro ao buscar os dados das chaves:', error);
        // Tratar o erro de acordo com as necessidades do seu aplicativo
      });
  };

  const deletaChave = async (id) => {
    const userConfirmed = window.confirm('Tem certeza que deseja excluir essa chave?');

    if (userConfirmed) {
      try {
        await fetch(`http://localhost:8080/api/chave/${id}`, {
          method: 'DELETE',
        });
        setErro({ mensagem: 'Chave deletada com sucesso.', sucesso: true });
        fetchChaves();
      } catch (error) {
        setErro({
          mensagem: 'Erro ao deletar a chave. Por favor, tente novamente.',
          sucesso: false,
        });
        // Tratar o erro de acordo com as necessidades do seu aplicativo
      }
    }
  };

  useEffect(() => {
    // Função para buscar os dados das chaves ao carregar o componente
    fetchChaves();
  }, []);

  return (
    <div className="container mt-4">
      {erro && <Erro mensagem={erro.mensagem} sucesso={erro.sucesso} />}
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Nome da Chave</th>
            <th>Sala</th>
            <th>Excluir</th>
            <th>Alterar</th>
          </tr>
        </thead>
        <tbody>
          {chaves.map((chave) => (
            <tr key={chave.id}>
              <td>{chave.nome}</td>
              <td>{chave.sala.descricaosala}</td>
              <td>
                <Button variant="danger" onClick={() => deletaChave(chave.id)}>
                  Excluir
                </Button>
              </td>
              <td>
                <Button variant="success" onClick={() => handleAlterarClick(chave)}>
                  Alterar
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      {showModal && chaveSelecionada && (
        <ModalChave
          chave={chaveSelecionada}
          onClose={() => setShowModal(false)}
          onSubmit={handleAlterarSubmit}
        />
      )}
    </div>
  );
};

export default TabelaChave;
