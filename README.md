# Autosellix - Araç Satış Yönetim Sistemi

## 📋 Proje Hakkında

Autosellix, galeristlerin araç satış işlemlerini yönetebilecekleri modern bir web uygulamasıdır. Spring Boot tabanlı bu REST API, araç satışı, müşteri yönetimi, hesap takibi ve güvenli kimlik doğrulama özelliklerini içerir.

## 🚀 Özellikler

### 🔐 Kimlik Doğrulama ve Güvenlik
- JWT (JSON Web Token) tabanlı kimlik doğrulama
- Spring Security entegrasyonu
- Refresh token desteği
- Güvenli şifre yönetimi

### 🚗 Araç Yönetimi
- Araç ekleme, düzenleme, silme ve listeleme
- Araç durumu takibi (Satılabilir/Satıldı)
- Plaka, marka, model ve üretim yılı bilgileri
- Fiyat yönetimi (TL/USD)
- Hasar fiyatı takibi

### 👥 Kullanıcı Yönetimi
- Galerist hesap yönetimi
- Müşteri bilgileri takibi
- Adres yönetimi
- Hesap işlemleri

### 💰 Satış İşlemleri
- Satış kayıtları
- Satış geçmişi
- Gelir takibi

## 🛠️ Teknolojiler

- **Backend Framework:** Spring Boot 3.4.5
- **Java Version:** 17
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA / Hibernate
- **Security:** Spring Security + JWT
- **Build Tool:** Maven
- **Lombok:** Kod tekrarını azaltmak için
- **Validation:** Spring Boot Validation

## 📦 Kurulum

### Gereksinimler
- Java 17 veya üzeri
- Maven 3.6+
- PostgreSQL 12+

### Adımlar

1. **Repository'yi klonlayın:**
```bash
git clone https://github.com/firatdemir47/Autosellix.git
cd Autosellix
```

2. **PostgreSQL veritabanını hazırlayın:**
```sql
CREATE DATABASE postgres;
CREATE SCHEMA autosellix;
```

3. **Veritabanı bağlantı ayarlarını yapılandırın:**
`src/main/resources/application.properties` dosyasında:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=21472147
```

4. **Uygulamayı çalıştırın:**
```bash
mvn spring-boot:run
```

Uygulama `http://localhost:8080` adresinde çalışacaktır.

## 🏗️ Proje Yapısı

```
src/main/java/com/firatdemir/
├── config/          # Yapılandırma sınıfları
├── controller/      # REST API controller'ları
├── dto/            # Data Transfer Objects
├── enums/          # Enumeration sınıfları
├── exception/      # Özel exception'lar
├── handler/        # Exception handler'lar
├── jwt/            # JWT işlemleri
├── model/          # Entity sınıfları
├── repository/     # Data access layer
├── service/        # Business logic
├── starter/        # Ana uygulama sınıfı
└── utils/          # Yardımcı sınıflar
```

## 📊 Veritabanı Modelleri

### Ana Entity'ler:
- **Car:** Araç bilgileri (plaka, marka, model, fiyat, durum)
- **User:** Kullanıcı bilgileri (kimlik doğrulama)
- **Gallerist:** Galerist bilgileri
- **Customer:** Müşteri bilgileri
- **Account:** Hesap işlemleri
- **Address:** Adres bilgileri
- **SaledCar:** Satılan araç kayıtları
- **GalleristCar:** Galerist-Araç ilişkisi
- **RefreshToken:** Token yenileme

### Enum'lar:
- **CarStatusType:** SALABLE, SALED
- **CurrencyType:** TL, USD

## 🔌 API Endpoints

### Kimlik Doğrulama
- `POST /auth/register` - Kullanıcı kaydı
- `POST /auth/authenticate` - Giriş yapma
- `POST /auth/refresh-token` - Token yenileme

### Araç İşlemleri
- `GET /cars` - Araç listesi
- `POST /cars` - Yeni araç ekleme
- `PUT /cars/{id}` - Araç güncelleme
- `DELETE /cars/{id}` - Araç silme

### Diğer Endpoints
- Galerist yönetimi
- Müşteri yönetimi
- Hesap işlemleri
- Adres yönetimi
- Satış kayıtları

## 🔧 Yapılandırma

### JWT Ayarları
- Token geçerlilik süresi: 2 dakika
- Refresh token desteği
- Güvenli secret key kullanımı

### Veritabanı Ayarları
- Hibernate DDL: `update` (otomatik şema güncelleme)
- SQL logları aktif
- PostgreSQL bağlantısı

## 🧪 Test

```bash
# Unit testleri çalıştırma
mvn test

# Integration testleri
mvn verify
```

## 📝 Geliştirme Notları

- Lombok kullanılarak boilerplate kod azaltılmıştır
- Spring Security ile güvenlik sağlanmıştır
- JPA/Hibernate ile veritabanı işlemleri yapılmaktadır
- RESTful API standartlarına uygun tasarım
- Exception handling mekanizması mevcuttur

## 🤝 Katkıda Bulunma

1. Fork yapın
2. Feature branch oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

## 📄 Lisans

Bu proje MIT lisansı altında lisanslanmıştır.

## 👨‍💻 Geliştirici

**Firat Demir**
- Email: dferhat263@gmail.com
- GitHub: [firatdemir47](https://github.com/firatdemir47)
- Proje: Autosellix
- Versiyon: 0.0.1-SNAPSHOT

---

**Not:** Bu proje Spring Boot 3.4.5 ve Java 17 ile geliştirilmiştir. Geliştirme ortamınızda bu versiyonların kurulu olduğundan emin olun.
