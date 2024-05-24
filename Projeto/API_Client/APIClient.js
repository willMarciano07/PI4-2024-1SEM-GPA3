class APIClient {
    constructor(baseURL) {
      this.baseURL = baseURL;
    }
  
    async get(endpoint, params = {}) {
      const url = this._buildURL(endpoint, params);
      const options = {
        method: 'GET',
        headers: this.headers
      };
  
      try {
        const response = await fetch(url, options);
        const data = await response.json();
        return data;
      } catch (error) {
        throw new Error(error);
      }
    }
  
    async post(endpoint, data, params = {}) {
      const url = this._buildURL(endpoint, params);
      const options = {
        method: 'POST',
        headers: this.headers,
        body: JSON.stringify(data)
      };
  
      try {
        const response = await fetch(url, options);
        const result = await response.json();
        return result;
      } catch (error) {
        throw new Error(error);
      }
    }
  
    async put(endpoint, id, data, params = {}) {
      const url = this._buildURL(`${endpoint}/${id}`, params);
      const options = {
        method: 'PUT',
        headers: this.headers,
        body: JSON.stringify(data)
      };
  
      try {
        const response = await fetch(url, options);
        const result = await response.json();
        return result;
      } catch (error) {
        throw new Error(error);
      }
    }
  
    async delete(endpoint, id, params = {}) {
      const url = this._buildURL(`${endpoint}/${id}`, params);
      const options = {
        method: 'DELETE',
        headers: this.headers
      };
  
      try {
        const response = await fetch(url, options);
        if (response.status === 204) {
          return true;
        } else {
          throw new Error('Falha ao excluir');
        }
      } catch (error) {
        throw new Error(error);
      }
    }
  
    _buildURL(endpoint, params) {
      let url = `${this.baseURL}${endpoint}`;
  
      if (Object.keys(params).length > 0) {
        url += '?';
        for (const key in params) {
          url += `${key}=${params[key]}&`;
        }
        url = url.slice(0, -1); // Remove o último '&'
      }
  
      return url;
    }
  }

// Exemplos para implementação dessa classe nos códigos JS  
// const apiClient = new APIClient('https://api.exemplo.com');

// // GET request
// apiClient.get('/usuarios')
//   .then(data => console.log(data))
//   .catch(error => console.error(error));

// // POST request
// const dados = { nome: 'João Silva', email: 'joaosilva@exemplo.com' };
// apiClient.post('/usuarios', dados)
//   .then(result => console.log(result))
//   .catch(error => console.error(error));

// // PUT request
// const id = 123;
// const updatedData = { nome: 'João Silva Atualizado', email: 'joaosilvaatualizado@exemplo.com' };
// apiClient.put('/usuarios', id, updatedData)
//   .then(result => console.log(result))
//   .catch(error => console.error(error));

// // DELETE request
// apiClient.delete('/usuarios', id)
//   .then(() => console.log('Usuário excluído com sucesso'))
//   .catch(error => console.error(error));