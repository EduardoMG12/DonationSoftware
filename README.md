Como rodar o projeto 

No terminal, navegue até o diretório do projeto e execute:

baixei um driver mysql-connector-j
https://dev.mysql.com/downloads/connector/j/
Platform Independent

```bash

docker-compose up -d


```
Verificar o Container:

Confirme que o banco está rodando:

```bash

docker ps

```

Conecte-se ao banco para verificar os dados:

```bash

docker exec -it donation_db mysql -u user -p
# após o comando rodar o terminal pedirá a senha digite: password
```

