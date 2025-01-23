PRUEBA PARA EMPRESA ACCENTURE

Para ejecutar el proyecto debes tener las siguientes variables de entorno y configurarlas 
en el application.properties

- spring.application.name=FRANCHISE_PROJECT
- spring.datasource.url=${SPRING_DATASOURCE_URL}
- spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
- spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
- spring.jpa.show-sql=true
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.jpa.hibernate.ddl-auto=${SPRING_JPA_HIBERNATE_DDL_AUTO}
- spring.jpa.properties.hibernate.dialect=${SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT}

- env_variables (Esto es para GCP) si se ejecuta local no hay necesidad de esto:
    - SPRING_DATASOURCE_URL: <your_my_sql>
    - SPRING_DATASOURCE_USERNAME: <your_username<
    - SPRING_DATASOURCE_PASSWORD: <your password>
    - SPRING_JPA_HIBERNATE_DDL_AUTO: update
    - SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT:org.hibernate.dialect.MySQL8Dialect

El microservicio está desplegado con GCP y Mysql, este es el link: 

https://franchise-cloud-448714.ue.r.appspot.com/api/product/getAll

En la ruta de controllers puedes ver todas las rutas para hacer las diferentes pruebas.

Si quieres ejecutarlo en el local descargate el proyecto y create una base de datos local y ya conectas el proyecto
a esa base de datos.

El proyecto se estará actualizando automáticamente (la base de datos) gracias al dll update. Como elijas ponerlo

Aquí hay algunos insert para la base de datos.
