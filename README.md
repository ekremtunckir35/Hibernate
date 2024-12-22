# Hibernate Framework / Hibernate Çatısı

## Overview / Genel Bakış

Hibernate is an open-source and lightweight Java framework used to simplify database interactions in Java applications. It implements Java Persistence API (JPA) specifications for object-relational mapping (ORM).

Hibernate, Java uygulamalarında veritabanı etkileşimlerini basitleştirmek için kullanılan açık kaynaklı ve hafif bir Java çerçevesidir. Nesne-ilişkisel eşleme (ORM) için Java Kalıcılık API'si (JPA) özelliklerini uygular.

### Key Features / Temel Özellikler:
- **Open Source and Lightweight / Açık Kaynak ve Hafif:** Licensed under LGPL, making it free to use and integrate.
  LGPL lisansı altında açık kaynaklıdır ve ücretsiz olarak kullanılabilir.
- **Fast Performance / Hızlı Performans:** Leverages caching mechanisms with first-level and optional second-level caches.
  Birinci seviye ve isteğe bağlı ikinci seviye önbellek mekanizmalarını kullanır.
- **Database Independent Queries / Veritabanından Bağımsız Sorgular:** Supports HQL (Hibernate Query Language), a database-independent object-oriented version of SQL.
  SQL'in nesne yönelimli bir versiyonu olan HQL'yi destekler.
- **Automatic Table Creation / Otomatik Tablo Oluşturma:** Simplifies database table creation and management.
  Veritabanı tablo oluşturmayı ve yönetimini kolaylaştırır.
- **Simplified Complex Joins / Karmaşık Birleştirmeyi Basitleştirir:** Fetches data from multiple tables effortlessly.
  Birden fazla tablodan kolayca veri alır.
- **Query Statistics and Database State / Sorgu İstatistikleri ve Veritabanı Durumu:** Offers detailed query statistics and insights into database operations.
  Ayrıntılı sorgu istatistikleri ve veritabanı işlemleri hakkında bilgiler sağlar.

---

## Advantages / Avantajlar

### 1. Open Source and Lightweight / Açık Kaynak ve Hafif
Hibernate is an open-source ORM framework that ensures lightweight application design and reduces development time.
Hibernate, hafif uygulama tasarımını garanti eden ve geliştirme süresini azaltan açık kaynaklı bir ORM çerçevesidir.

### 2. Improved Performance / Geliştirilmiş Performans
Hibernate provides caching mechanisms to enhance performance:
Hibernate, performansı artırmak için önbellekleme mekanizmaları sağlar:
- **First-Level Cache / Birinci Seviye Önbellek:** Default session-level cache.
  Varsayılan oturum seviyesinde önbellek.
- **Second-Level Cache / İkinci Seviye Önbellek:** Optional, application-wide cache.
  İsteğe bağlı, tüm uygulama genelinde önbellek.

### 3. HQL (Hibernate Query Language) / Hibernate Sorgu Dili
Write database-independent queries with object-oriented syntax, reducing the need for database-specific SQL modifications.
Nesne yönelimli sözdizimi ile veritabanından bağımsız sorgular yazabilir, veritabanına özgü SQL değişikliklerini azaltabilirsiniz.

### 4. Simplified CRUD Operations / Basitleştirilmiş CRUD İşlemleri
Provides built-in methods for common database operations like create, read, update, and delete.
Oluşturma, okuma, güncelleme ve silme gibi yaygın veritabanı işlemleri için yerleşik yöntemler sağlar.

### 5. Automatic Schema Management / Otomatik Şema Yönetimi
Automatically generates database schemas based on Java class mappings.
Java sınıf eşlemelerine dayalı olarak veritabanı şemalarını otomatik olarak oluşturur.

---

## Core Components / Temel Bileşenler

### Hibernate Architecture Layers / Hibernate Mimarisi Katmanları:
1. **Java Application Layer / Java Uygulama Katmanı:** The interface where developers interact with Hibernate.
   Geliştiricilerin Hibernate ile etkileşime geçtiği arayüz.
2. **Hibernate Framework Layer / Hibernate Çatısı Katmanı:** Core framework handling ORM functionalities.
   ORM işlevlerini yöneten temel çerçeve.
3. **Backend API Layer / Arka Uç API Katmanı:** Interacts with existing APIs like JDBC, JTA, and JNDI.
   JDBC, JTA ve JNDI gibi mevcut API'lerle etkileşim kurar.
4. **Database Layer / Veritabanı Katmanı:** Handles actual database operations.
   Gerçek veritabanı işlemlerini yönetir.

### Key Elements / Temel Elemanlar:
- **SessionFactory:** Provides factory methods to get session objects.
  Oturum nesnelerini elde etmek için fabrika yöntemleri sağlar.
- **Session / Oturum:** Represents a unit of work and wraps JDBC connection.
  Bir çalışma birimini temsil eder ve JDBC bağlantısını sarar.
- **Transaction / İşlem:** Ensures ACID properties during database operations.
  Veritabanı işlemleri sırasında ACID özelliklerini sağlar.
- **Query and Criteria API / Sorgu ve Kriter API'si:** Facilitates querying the database in an object-oriented manner.
  Veritabanını nesne yönelimli bir şekilde sorgulamayı kolaylaştırır.

---

## Setup and Configuration / Kurulum ve Yapılandırma

### Using Maven / Maven Kullanarak:
Add the following dependencies to your `pom.xml` file:
Aşağıdaki bağımlılıkları `pom.xml` dosyanıza ekleyin:
```xml
<dependencies>
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.6.3.Final</version>
    </dependency>
    <dependency>
        <groupId>javax.persistence</groupId>
        <artifactId>javax.persistence-api</artifactId>
        <version>2.2</version>
    </dependency>
</dependencies>
```

### Configuration File (`hibernate.cfg.xml`) / Yapılandırma Dosyası (`hibernate.cfg.xml`):
```xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
        <property name="hibernate.connection.username">your_username</property>
        <property name="hibernate.connection.password">your_password</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="hibernate.show_sql">true</property>
        <mapping resource="com/example/entity/YourEntity.hbm.xml"/>
    </session-factory>
</hibernate-configuration>
```

---

## Example Application / Örnek Uygulama

### Persistent Class / Kalıcı Sınıf:
```java
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    // Getters and Setters
}
```

### Main Class / Ana Sınıf:
```java
public class HibernateApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setSalary(75000);

        session.save(emp);
        tx.commit();
        session.close();
    }
}
```

---

## Resources / Kaynaklar
- [Hibernate Documentation](https://hibernate.org/documentation/)
- [JPA Specification](https://jcp.org/en/jsr/detail?id=338)
- [EHCache Documentation](https://www.ehcache.org/documentation/)

---

## License / Lisans
This project is licensed under the MIT License - see the LICENSE file for details.
Bu proje MIT Lisansı altında lisanslanmıştır - detaylar için LICENSE dosyasına bakınız.
