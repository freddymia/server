# server
Ecommerce Test Exercise



## Configure
Before running the application you need to configure the parameters for connection to the database:

server/src/main/resources/application.properties

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=postgres
```

## Run
The exercise is based on Spring Boot therefore to execute it

```bash
mvnw spring-boot:run
```

## API Resources

Endpoint List

Producto Resources

```bash
GET       /api/v1/producto/all                 Lista de todos los productos                                                                   
POST      /api/v1/producto/save                Agrega un producto
DELETE    /api/v1/producto/delete/{id}         Elimina un producto
POST      /api/v1/producto/update/{id}         Actualiza un producto
```

Carrito Resources

```bash
GET       /api/v1/carro/{id}/productos         Lista todos los producto de un carrito                                                                
POST      /api/v1/carro/add-producto           Agrega un producto al carrito
DELETE    /api/v1/carro/remove-producto        Elimina un producto del carrito
POST      /api/v1/carro/update-producto        Actualiza un producto del carrito
GET       /api/v1/carro/{id}/checkout          Devuelve el costo final de los productos del carrito y actualiza su estado a COMPLETADO
```








