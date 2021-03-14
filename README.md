

<h1 align="center">Cloud_Computing</h1>
<div align="center">

[![Status](https://img.shields.io/badge/status-finished-success.svg)]()

</div>

## 📝 Table of Contents

- [📝 Table of Contents](#-table-of-contents)
- [🧐 About <a name = "about"></a>](#-about-)
- [🔑 Prerequisites <a name = "prerequisites"></a>](#-prerequisites-)
- [⛏️ Built Using <a name = "built_using"></a>](#️-built-using-)
- [✍️ Authors <a name = "authors"></a>](#️-authors-)

## 🧐 About <a name = "about"></a>
A web chat application hosted on Azure cloud services. 

<p align="center">
  <img src="https://user-images.githubusercontent.com/57731778/111081829-750c4080-8505-11eb-9f9f-687c38f2c592.gif" >
</p>

## 🔑 Prerequisites <a name = "prerequisites"></a>

In order to run the application you will need to configure the application.properties file in the resources folder as shown in the example below:

```
logging.level.org.springframework.jdbc.core=DEBUG

# DB
spring.datasource.url=your-db-url
spring.datasource.username=your-username
spring.datasource.password=your-password

jwt.secret= your-secret-key
jwt.expirationMs= 864000000

server.servlet.contextPath=/api
```

## ⛏️ Built Using <a name = "built_using"></a>

- [Java](www.java.com) - Programming language
- [Apache Maven](www.maven.apache.org) - Build automation tool
- [Spring Framework](spring.io) - Build automation tool
- [Vue.js](https://vuejs.org/) - Frontend JavaScript Framework
- [Microsoft SQL Server](https://www.microsoft.com/pl-pl/sql-server/) - Database

## ✍️ Authors <a name = "authors"></a>

* [Przemysław Zdrzalik](https://github.com/ZdrzalikPrzemyslaw)
* [Julia Szymańska](https://github.com/JuliaSzymanska)
* [Hubert Gawłowski](https://github.com/hubertgaw)
* [Kamil Kiszko-Zgierski](https://github.com/KiszczixIsCoding)
* [Martyna Piasecka](https://github.com/MartynaCys)
