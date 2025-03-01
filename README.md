## Como subir os containers

### Subir todos os serviços de uma vez
No diretório onde o arquivo `docker-compose.yml` está localizado, execute o seguinte comando para subir os containers em segundo plano:

```bash
docker-compose up -d
```

### Subir Rabbit

```bash
docker-compose up -d rabbit
```

### Subir Redis

```bash
docker-compose up -d redis
```

### Parar os Containers

```bash
docker-compose down
```

### Para separadamente 

```bash
docker-compose stop redis
```

```bash
docker-compose stop rabbit
```
