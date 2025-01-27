WeatherApp 🌤️
WeatherApp, kullanıcıların mevcut konumlarına göre hava durumu bilgilerini anlık olarak görüntüleyebileceği modern bir Android uygulamasıdır. MVVM mimarisi ve Jetpack Compose ile geliştirilmiş olup, şık ve kullanıcı dostu bir deneyim sunar.

📌 Özellikler
🌡️ Mevcut Hava Durumunu Çekme
Kullanıcıların bulunduğu konumun hava durumu verilerini gerçek zamanlı olarak görüntülemesini sağlar.
🎨 Modern Tasarım
Jetpack Compose kullanılarak tasarlanmış, estetik ve kolay kullanımlı bir arayüz.
🔐 Güvenli İzin Yönetimi
Kullanıcıdan yalnızca gerekli olan konum izinlerini alır ve hata durumlarını kullanıcı dostu mesajlarla yönetir.
📂 Proje Yapısı
Uygulama dört ana paketten oluşur:

data
API işlemleri ve veri modellerini içerir.
Room Database (gerekirse genişletilebilir).

di
Hilt bağımlılık enjeksiyonu yapılandırması.

domain
Veri işleme ve iş kurallarını içerir.

presentation
Kullanıcı arayüzü ve ekranların bulunduğu kısım.

🛠️ Kullanılan Teknolojiler
Kotlin
Jetpack Compose
Hilt (Dependency Injection)
Coroutines & Flow
Retrofit


🚀 Çalıştırmak İçin
Projeyi klonlayın:
bash
Kopyala
Düzenle
git clone https://github.com/kullaniciadi/WeatherApp.git
Android Studio'da projeyi açın.
Gerekli bağımlılıkları (Gradle) senkronize edin.
Uygulamayı cihazınıza/emülatöre yükleyin ve çalıştırın!


📷 Ekran Görüntüleri

<img src="https://github.com/user-attachments/assets/1fc5005a-6b46-432f-8816-35891ef3a29c" alt="Screenshot 1" width="300"/>

<img src="https://github.com/user-attachments/assets/995a2931-121c-40b5-8fad-eeabd8b16b1b" alt="Screenshot 2" width="300"/>

<img src="https://github.com/user-attachments/assets/e827260b-39ae-4937-9a1e-3c1294b71375" alt="Screenshot 3" width="300"/>


