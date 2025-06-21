
#### Execute Liquibase in H2(Embedded local as file system)
```xml
<plugin>
    <groupId>org.liquibase</groupId>
    <artifactId>liquibase-maven-plugin</artifactId>
    <version>3.4.1</version>
   <configuration>
        <changeLogFile>
           /src/main/resources/liquibase-outputChangeLog.xml
        </changeLogFile>
        <driver>org.h2.Driver</driver>
        <url>jdbc:h2:file:~/taskapp</url>
        <username>sa</username>
        <password>password</password>
     </configuration>               
</plugin>
```

```xml

<properties>
    <querydsl-maven-plugin.version>7.0</querydsl-maven-plugin.version>
    <!-- h2.version from spring parent-->
    <h2-db-version>${h2.version}</h2-db-version>
    <!-- liquibase.version from spring parent-->
    <liquibase-maven-plugin>${liquibase.version}</liquibase-maven-plugin>
</properties>

<plugins>

    <plugin>
        <groupId>org.liquibase</groupId>
        <artifactId>liquibase-maven-plugin</artifactId>
        <version>${liquibase-maven-plugin}</version>
    
        <executions>
            <execution>
                <id>table-from-liquibase</id>
                <phase>generate-sources</phase>
                <goals>
                    <goal>update</goal>
                </goals>
                <configuration>
                    <promptOnNonLocalDatabase>false</promptOnNonLocalDatabase>
                    <defaultSchemaName>h2</defaultSchemaName>
                    <changeLogFile>src/main/resources/db.changelog/changelog.yml</changeLogFile>
                    <url>jdbc:h2:${project.build.directory}/h2/tl_tables;INIT=create schema IF NOT EXISTS MYSCHEMA;</url>
                    <username>sa</username>  <!-- Directly specify the username -->
                    <password>password</password>  <!--  Consider using a more secure method for password -->
                </configuration>
            </execution>
        </executions>
        <dependencies>
            <dependency>
                <groupId>com.h2database</groupId>
                <artifactId>h2</artifactId>
                <version>${h2-db-version}</version>
            </dependency>
        </dependencies>
    </plugin>
    
    
    <plugin>
    <groupId>io.github.openfeign.querydsl</groupId>
    <artifactId>querydsl-maven-plugin</artifactId>
    <version>${querydsl-maven-plugin.version}</version>
    
    <executions>
        <execution>
            <configuration>
                <jdbcDriver>org.h2.Driver</jdbcDriver>
                <jdbcUrl>jdbc:h2:${project.build.directory}/h2/tl_tables;</jdbcUrl>
                <jdbcUser>sa</jdbcUser>
                <jdbcPassword>password</jdbcPassword>
                <packageName>com.ilan.query.sql</packageName>
                <targetFolder>${project.basedir}/target/generated-sources/java</targetFolder>
                <namePrefix>S</namePrefix>
                <schemaToPackage>true</schemaToPackage>
                <exportAll>false</exportAll>
                <exportTables>true</exportTables>
                <exportBeans>true</exportBeans>
                <beanAddFullConstructor>true</beanAddFullConstructor>
                <beanAddToString>true</beanAddToString>
                <beanPrefix>P</beanPrefix>
                <beanPrintSupertype>true</beanPrintSupertype>
            </configuration>
            <id>querydsl-sql-from-liquibase</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>export</goal>
            </goals>
        </execution>
    </executions>
    
    <dependencies>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>${h2-db-version}</version>
        </dependency>
    </dependencies>
    </plugin>
        
</plugins>

```