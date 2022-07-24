# ShoppingProject
## Enterprise E-Commerce Shopping Project

## E-Ticaret Alışveriş Projesi - Kurumsal Mimari ile

### Bu proje bir E-Ticret alışveriş projesi hakkındadır. Kurumsal mimariye uygun ve SOLID prensiplerine göre yazılmıştır.
### Bu proje Back-end tarafıdır. Java Spring Boot JPA ile yazılmıştır. PostgreSQL ve REST API kullanılmıştır. JSON Web Token kullanılmıştır.
### Projede yapılan güncellemeler bölüm bölüm eklenecektir. 

## Bölüm 1
#### 1.User, Product, Category, Order, RefreshToken nesneleri eklendi(Entity)
  User--> Id, Username, Password, Firstname, Lastname, Email, Address, Userphoto, Currentcart, Authoritylevel, Ohonenumber, Gender
  Product--> Id, Name, Detail, Image, UnitPrice, Units_In_Stock, CategoryId
  Category--> Id, Categoryname, products
  Order--> Id, Ordercontent, Orderstate, Orderdate, user
  RefreshToken --> Id, User, Token, Expirydate
#### 2.PostgreSQL tarafında veribanı oluşturuldu.
#### 3.User, Product, Order, RefreshToken nesneleri için service, manager ve controller oluşturuldu.
#### 4.Sisteme yeni veri eklendiğinde seçilmiş verilerin boş olmaması ve veriye göre sadece rakam veya harf ayrımı yapılmıştır.

### Project Explorer

![1](https://user-images.githubusercontent.com/36435160/179939569-9eff881e-7d0a-49d1-b7cc-904667c8be7a.png)

#### Mavi kutucuklu alan
Api controller yönetildiği alandır. POST, GET, UPDATE, DELETE methodları burada yazılmıştır. Tüm sayfa istekleri, veri giriş istekleri, veri değişikliği ve silinme
istekleri ilk olarak buraya gelmektedir.

#### Yeşil kutucuklu alan

Burada servis ve iş katmanımız yer almaktadır. Api isteğiyle karşılanmaya başlayan istek methoda göre servis içerisindeki methoda yönlendirilir. İş katmanı servisi implement eder.
burada istekle ilgili varsa kurallarımızı yazabiliriz.

#### Mor kutucuklu alan

PostgreSQL'e JPA repository kullanılarak buradan ulaşılır.JPA repository'ye uygun komutlar burada yazılabilir. Duruma göre @Query anotasyonu kullanılarak özel sorgular el ile yazılabilir.

#### Sarı kutucuklu alan
Entity sınıflarının tutulduğu yerdir. Entity ve içerisindeki kodlar veritabanındaki tablolara ve tablo içerisindeki sütunlara karşılık gelir. Entity sınıfta yapılan tüm
değişiklikler postgreSQL tarafında otomatik olarak güncellenir. Aynı zamanda OnetoMany ManyToOne ilişkileri yazılmıştır.

#### Gri Kutucuklu alan
Uygulama katmanları arasında veri transfer etmek için kullanılmıştır.

#### Kırmızı kutucuklu alan

JSON Web Token oluşturmak yenilemek ve kontrol etmek için yazılmıştır. Kullanıcıların ulaşıp ulaşamayacağı sayfalar belirlenmiştir. Kullanıcıların bazı sayfalara erişimi için
token kullanması gerekmektedir.

## Bölüm 2

### API kullanımına örnek olarak 
![apilereornek](https://user-images.githubusercontent.com/36435160/179960098-f7cc6aaa-814d-455c-af83-abf816628530.png)

GET POST method kullanımı örnekte gösterilmektedir

### Servislere örnek olarak product servisimiz
![ornekproductlist](https://user-images.githubusercontent.com/36435160/179959216-bf0b4556-7bd3-4a9c-9553-36cf4fb73528.png)
Tüm veriler JPA Repository kullanımına uygun olarak yazılmıştır.

### Business katmanımıza örnek
![businessornek](https://user-images.githubusercontent.com/36435160/179960497-0fdc053c-a943-4a26-abbd-23de78d8e7e8.png)

### ProductDao örnek
![daoornek](https://user-images.githubusercontent.com/36435160/179960877-408dd3aa-c39f-4a53-a626-0b5201991afc.png)
JPA Repository için uygun olabilecek olanlar o şekilde yazılmıştır. Özelleştirilmiş sorgular için @Query anotasyonu kullanılmıştır.

### OneToMany ilişkilendirilmiş User Entity örneği -lombok kullanılmıştır
![userornek](https://user-images.githubusercontent.com/36435160/179961516-8abe5652-38cf-40e5-b4f1-5e6df2cef89e.png)

### ManyToOne ilişkilendirilmiş Order Entity örneği -lombok kullanılmıştır
![orderornek](https://user-images.githubusercontent.com/36435160/179961732-ec953946-5a33-4b6c-b2b3-2655d245bc50.png)

### OneToMany ilişkilendirilmiş Category Entity örneği -lombok kullanılmamıştır
![categoryornek](https://user-images.githubusercontent.com/36435160/179962014-f1653755-e43b-4006-9431-1c1cb1eb1cfc.png)

### Json Web Token kullanımı
![jwtornek](https://user-images.githubusercontent.com/36435160/179962798-d62b2d5a-984a-4bd0-8ee3-e4d8a2342e7b.png)
### Json Web Token security ile gönderilen isteklerin erişim kısıtlması
![securityornek](https://user-images.githubusercontent.com/36435160/179962977-e3580cad-1420-4183-b61d-e1e0efe00552.png)

