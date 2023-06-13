import React, { useState, useEffect } from 'react';
import axios from 'axios';

import '../../styles/formulario.css';

const ModalSala = ({ sala, onSubmit, onClose }) => {
  const [id, setId] = useState('');
  const [numeroSala, setNumeroSala] = useState(1);
  const [descricaoSala, setDescricaoSala] = useState('');
  const [erro, setErro] = useState('');

  useEffect(() => {
    if (sala) {
      setId(sala.id);
      setNumeroSala(sala.numerosala);
      setDescricaoSala(sala.descricaosala);
    }
  }, [sala]);

  const Erro = ({ mensagem, sucesso }) => {
    const estilo = sucesso ? 'mensagem-sucesso' : 'mensagem-fracasso';
    return <div className={estilo}>{mensagem}</div>;
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    if (numeroSala === '') {
      setErro({ mensagem: 'Campo obrigatório: Número', sucesso: false });
      return;
    }

    if (descricaoSala === '') {
      setErro({ mensagem: 'Campo obrigatório: Descrição', sucesso: false });
      return;
    }

    let data = {};

    if (id) {
      data = {
        id: id,
        numerosala: numeroSala,
        descricaosala: descricaoSala,
      };
      // Atualização (Editar)
      axios
        .put(`http://localhost:8080/api/sala`, data)
        .then((response) => {
          console.log('Dados atualizados com sucesso:', response.data);
          onSubmit(response.data);
          setId('');
          setNumeroSala('');
          setDescricaoSala('');
          setErro('');
          onClose();
        })
        .catch((error) => {
          console.error('Erro ao atualizar os dados:', error);
          setErro({ mensagem: 'Erro ao atualizar a sala. Por favor, tente novamente.', sucesso: false });
        });
    } else {
      data = {
        numerosala: numeroSala,
        descricaosala: descricaoSala,
      };
      // Inserção (Salvar)
      axios
        .post('http://localhost:8080/api/sala', data)
        .then((response) => {
          console.log(response.data, response.data.status);
          if (response.data.status === 200) {
            setId('');
            setNumeroSala('');
            setDescricaoSala('');
            setErro('');
            onClose();
          } else {
            setErro({ mensagem: 'Erro ao adicionar a sala. Por favor, tente novamente.', sucesso: false });
          }
        })
        .catch((error) => {
          console.error('Erro ao salvar os dados:', error);
          setErro({ mensagem: 'Erro ao adicionar a sala. Por favor, tente novamente.', sucesso: false });
        });
    }
  };

  const handleModalContentClick = (event) => {
    // Impede a propagação do evento de clique para o contêiner do modal
    event.stopPropagation();
  };

  const handleModalClose = () => {
    setErro('');
    onClose();
  };

  return (
    <div className="modal" onClick={handleModalClose}>
      <div className="modal-content" onClick={handleModalContentClick}>
        <h2>{id ? 'Editar Sala' : 'Inserir Sala'}</h2>
        {erro && <Erro mensagem={erro.mensagem} sucesso={erro.sucesso} />}
        <form onSubmit={handleSubmit} className="sala-form">
          <div className="form-group">
            <label htmlFor="id">ID:</label>
            <input type="number" id="id" value={id} onChange={(e) => setId(e.target.value)} disabled />
          </div>
          <div className="form-group">
            <label htmlFor="numeroSala">Número:{' '}
              {numeroSala === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
            <input
              type="number"
              id="numeroSala"
              value={numeroSala}
              onChange={(e) => setNumeroSala(e.target.value)}
              min={1}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="descricaoSala">Descrição:{' '}
              {descricaoSala === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
            <input
              type="text"
              id="descricaoSala"
              value={descricaoSala}
              onChange={(e) => setDescricaoSala(e.target.value)}
              required
            />
          </div>
          <div className="modal-buttons">
            <button type="submit" className="btn-salvar" id="btn-salvar">
              {id ? 'Atualizar' : 'Salvar'}
            </button>
            <button type="button" className="btn-fechar" onClick={handleModalClose}>
              Fechar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default ModalSala;
