import React, { useState, useEffect } from 'react';
import axios from 'axios';

import '../../styles/formulario.css';

const ModalPastoral = ({ pastoral, onSubmit, onClose }) => {
  const [id, setId] = useState('');
  const [nomePastoral, setNomePastoral] = useState('');
  const [descricaoPastoral, setDescricaoPastoral] = useState('');
  const [coordenador, setCoordenador] = useState('');
  const [dataCriacao, setDataCriacao] = useState(Date.now());
  const [dataEncerramento, setDataEncerramento] = useState('');
  const [erro, setErro] = useState('');

  useEffect(() => {
    if (pastoral) {
      setId(pastoral.id);
      setNomePastoral(pastoral.nomepastoral);
      setDescricaoPastoral(pastoral.descricaopastoral);
      setCoordenador(pastoral.coordenador ? JSON.stringify(pastoral.coordenador) : '');
      setDataCriacao(pastoral.datacriacao);
      setDataEncerramento(pastoral.dataencerramento);
    }
  }, [pastoral]);

  const Erro = ({ mensagem, sucesso }) => {
    const estilo = sucesso ? 'mensagem-sucesso' : 'mensagem-fracasso';
    return <div className={estilo}>{mensagem}</div>;
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    if (nomePastoral === '') {
      setErro({ mensagem: 'Campo obrigatório: Nome da Pastoral', sucesso: false });
      return;
    }

    if (descricaoPastoral === '') {
      setErro({ mensagem: 'Campo obrigatório: Descrição', sucesso: false });
      return;
    }

    let data = {};

    if (id) {
      data = {
        id: id,
        nomepastoral: nomePastoral,
        descricaopastoral: descricaoPastoral,
        coordenador: JSON.parse(coordenador),
        datacriacao: dataCriacao,
        dataencerramento: dataEncerramento,
      };
      // Atualização (Editar)
      axios
        .put(`http://localhost:8080/api/pastoral`, data)
        .then((response) => {
          console.log('Dados atualizados com sucesso:', response.data);
          onSubmit(response.data);
          setId('');
          setNomePastoral('');
          setDescricaoPastoral('');
          setCoordenador('');
          setDataCriacao('');
          setDataEncerramento('');
          setErro('');
          onClose();
        })
        .catch((error) => {
          console.error('Erro ao atualizar os dados:', error);
          setErro({
            mensagem: 'Erro ao atualizar a pastoral. Por favor, tente novamente.',
            sucesso: false,
          });
        });
    } else {
      data = {
        nomepastoral: nomePastoral,
        descricaopastoral: descricaoPastoral,
        coordenador: JSON.parse(coordenador),
        datacriacao: dataCriacao,
        dataencerramento: dataEncerramento,
      };
      // Inserção (Salvar)
      axios
        .post('http://localhost:8080/api/pastoral', data)
        .then((response) => {
          console.log(response.data, response.data.status);
          if (response.data.status === 200) {
            setId('');
            setNomePastoral('');
            setDescricaoPastoral('');
            setCoordenador('');
            setDataCriacao('');
            setDataEncerramento('');
            setErro('');
            onClose();
          } else {
            setErro({
              mensagem: 'Erro ao adicionar a pastoral. Por favor, tente novamente.',
              sucesso: false,
            });
          }
        })
        .catch((error) => {
          console.error('Erro ao salvar os dados:', error);
          setErro({
            mensagem: 'Erro ao adicionar a pastoral. Por favor, tente novamente.',
            sucesso: false,
          });
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
        <h2>{id ? 'Editar Pastoral' : 'Inserir Pastoral'}</h2>
        {erro && <Erro mensagem={erro.mensagem} sucesso={erro.sucesso} />}
        <form onSubmit={handleSubmit} className="pastoral-form">
          <div className="form-group">
            <label htmlFor="id">ID:</label>
            <input type="number" id="id" value={id} onChange={(e) => setId(e.target.value)} disabled />
          </div>
          <div className="form-group">
            <label htmlFor="nomePastoral">Nome da Pastoral:{' '}
              {nomePastoral === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
            <input
              type="text"
              id="nomePastoral"
              value={nomePastoral}
              onChange={(e) => setNomePastoral(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="descricaoPastoral">Descrição:{' '}
              {descricaoPastoral === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
            <input
              type="text"
              id="descricaoPastoral"
              value={descricaoPastoral}
              onChange={(e) => setDescricaoPastoral(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="coordenador">Coordenador:</label>
            <input
              type="text"
              id="coordenador"
              value={coordenador}
              onChange={(e) => setCoordenador(e.target.value)}
            />
          </div>
          <div className="form-group">
            <label htmlFor="dataCriacao">Data de Criação:</label>
            <input
              type="date"
              id="dataCriacao"
              value={dataCriacao}
              onChange={(e) => setDataCriacao(e.target.value)}
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

export default ModalPastoral;
