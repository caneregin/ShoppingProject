# ShoppingProject
Enterprise E-Commerce Shopping Project

E-Ticaret Alışveriş Projesi - Kurumsal Mimari ile

Bu proje bir E-Ticret alışveriş projesi hakkındadır. Kurumsal mimariye uygun ve SOLID prensiplerine göre yazılmıştır.
Bu proje Back-end tarafıdır. Java Spring Boot JPA ile yazılmıştır. PostgreSQL ve REST API kullanılmıştır. JSON Web Token kullanılmıştır.
Projede yapılan güncellemeler bölüm bölüm eklenecektir. 

Bölüm 1
1.User, Product, Category, Order, RefreshToken nesneleri eklendi(Entity)
  User--> Id, Username, Password, Firstname, Lastname, Email, Address, Userphoto, Currentcart, Authoritylevel, Ohonenumber, Gender
  Product--> Id, Name, Detail, Image, UnitPrice, Units_In_Stock, CategoryId
  Category--> Id, Categoryname, products
  Order--> Id, Ordercontent, Orderstate, Orderdate, user
  RefreshToken --> Id, User, Token, Expirydate
2.PostgreSQL tarafında veribanı oluşturuldu.
3.User, Product, Order, RefreshToken nesneleri için service, manager ve controller oluşturuldu.
4.Sisteme yeni veri eklendiğinde seçilmiş verilerin boş olmaması ve veriye göre sadece rakam veya harf ayrımı yapılmıştır.

Project Explorer

ABURAYA RESIM GELECEK

Mavi kutucuklu alan
Api controller yönetildiği alandır. POST, GET, UPDATE, DELETE methodları burada yazılmıştır. Tüm sayfa istekleri, veri giriş istekleri, veri değişikliği ve silinme
istekleri ilk olarak buraya gelmektedir.

Yeşil kutucuklu alan

Burada servis ve iş katmanımız yer almaktadır. Api isteğiyle karşılanmaya başlayan istek methoda göre servis içerisindeki methoda yönlendirilir. İş katmanı servisi implement eder.
burada istekle ilgili varsa kurallarımızı yazabiliriz.

Mor kutucuklu alan

PostgreSQL'e JPA repository kullanılarak buradan ulaşılır.JPA repository'ye uygun komutlar burada yazılabilir. Duruma göre @Query anotasyonu kullanılarak özel sorgular el ile yazılabilir.

Sarı kutucuklu alan
Entity sınıflarının tutulduğu yerdir. Entity ve içerisindeki kodlar veritabanındaki tablolara ve tablo içerisindeki sütunlara karşılık gelir. Entity sınıfta yapılan tüm
değişiklikler postgreSQL tarafında otomatik olarak güncellenir. Aynı zamanda OnetoMany ManyToOne ilişkileri yazılmıştır.

Gri Kutucuklu alan
Uygulama katmanları arasında veri transfer etmek için kullanılmıştır.

Kırmızı kutucuklu alan

JSON Web Token oluşturmak yenilemek ve kontrol etmek için yazılmıştır. Kullanıcıların ulaşıp ulaşamayacağı sayfalar belirlenmiştir. Kullanıcıların bazı sayfalara erişimi için
token kullanması gerekmektedir.
