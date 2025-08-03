# Makine Öğrenimi Entegre Eden Proje Yönetim Platformu (Gereksinim Dokümanı)

## 1.Giriş (Introduction)

### 1.1 Amaç (Purpose)

Bu belge, makine öğrenmesi destekli bir proje yönetim uygulamasının gereksinimlerini tanımlamak amacıyla hazırlanmıştır. Uygulama; görevlerin takibini kolaylaştırmak, kullanıcıların projelerini daha etkin yönetmesini sağlamak ve geçmiş verilere dayalı olarak görev süresi veya tamamlanma ihtimali gibi tahminler sunmak üzere tasarlanmıştır.

Belge, hem işlevsel hem de işlevsel olmayan gereksinimleri açıkça ortaya koyarak, sistemin ne yapması gerektiğini ve hangi sınırlamalar altında çalışacağını detaylandırır. Yazılım geliştirme sürecinin planlama, tasarım, test ve bakım aşamalarında referans alınacak temel kaynak olarak kullanılacaktır.

Bu belge aşağıdaki kişi ve gruplar tarafından kullanılmak üzere hazırlanmıştır:

- Yazılım Geliştiriciler: Sistemin işlevsel gereksinimlerine göre uygulamayı kodlayacak kişiler.

- Makine Öğrenmesi Uzmanları: Modelin veri ihtiyaçlarını, çıktıları ve sistemle entegrasyonunu değerlendirecek kişiler.

- Proje Yöneticileri: Projenin kapsamını ve gereksinimlerini anlayarak geliştirme sürecini koordine edecek kişiler.

- Test Uzmanları: Uygulamanın gereksinimlere uygunluğunu doğrulamak için test senaryolarını oluşturacak kişiler.

- Müşteriler veya Danışmanlar: Sistemden beklenen işlevselliği ve performansı değerlendirecek karar vericiler.

Belge teknik terimler içerebilir, bu nedenle okuyucuların temel yazılım geliştirme bilgisine sahip olması beklenmektedir.

### 1.2 Kapsam (Scope)

Bu proje kapsamında geliştirilecek yazılım ürününün adı ML Destekli Proje Yönetim Uygulamasıdır. Uygulama; kullanıcıların görev, ekip ve proje yönetimi süreçlerini dijital ortamda takip etmelerini sağlayacak bir web tabanlı sistemdir. Kullanıcı arayüzü Next.js ile geliştirilecek, arka uç işlemleri Spring Boot üzerinden yönetilecek, veri tabanı Oracle olacaktır. Ayrıca, Python ile geliştirilecek makine öğrenmesi modeli, geçmiş görev verilerine göre çeşitli tahminlerde bulunacaktır.

Yazılım; görev oluşturma, güncelleme, kullanıcı atama, proje bazlı raporlama ve takvim entegrasyonu gibi temel proje yönetim işlevlerini yerine getirecektir. Bununla birlikte, muhasebe veya finansal analiz gibi proje dışı işlevleri kapsamayacaktır.

Bu yazılımın amacı; bireylerin ve küçük ekiplerin, görevlerini organize etmelerini kolaylaştırmak ve veri temelli karar verme süreçlerini desteklemektir. Sistem, kullanıcı verilerinden öğrenerek görev süresi tahmini, önceliklendirme önerileri veya gecikme riski analizi gibi çıktılar üreterek yönetsel verimliliği artırmayı hedeflemektedir.

### 1.3 Tanımlar
### 1.4 Referanslar
### 1.5 Overwiev

## 2.Genel Açıklama (Overall Description)
### 2.1 Ürün Perskeptifi (Product Perspective)
Bu proje kapsamında geliştirilecek yazılım, bağımsız ve kendi içinde çalışabilen bir proje yönetim sistemidir. Uygulama; kullanıcıların görev, proje ve ekip süreçlerini yönetmelerine olanak tanıyan, web tabanlı bir çözümdür. Ancak yazılım, makine öğrenmesi bileşenleri ile birlikte çalışarak veri analizleri ve görev tahminleri sunacağı için, bu alt modüllerle etkileşimli bir yapıya sahiptir. Sistem, istemci tarafında Next.js ile sunulan kullanıcı arayüzü, sunucu tarafında Spring Boot ile geliştirilen REST API'ler, PostgreSQL veri tabanı ile kalıcı veri yönetimi ve Python tabanlı makine öğrenmesi modelleri ile karar destek bileşenlerinden oluşur. Bu bileşenlerin her biri belirli arayüzler aracılığıyla birbiriyle entegre şekilde çalışmaktadır.

#### 2.1.1 Sistem Arayüzler (System Interfaces)
Bu bölüm, yazılımın sistem gereksinimlerini karşılamak amacıyla etkileşimde bulunduğu her sistem arayüzünü ve bu arayüzlerin işlevselliğini açıklar. Geliştirilecek proje yönetim uygulaması; kullanıcı arayüzü, backend servisleri, makine öğrenmesi modülü ve veritabanı gibi bileşenlerin entegre çalışmasını sağlayan çeşitli arayüzlere sahiptir.

- Frontend (Next.js) ⇄ Backend (Spring Boot) Arayüzü

    - İşlevsellik: Kullanıcının tarayıcı üzerinden gerçekleştirdiği tüm işlemleri (görev ekleme, proje oluşturma, analiz görüntüleme vb.) backend’e iletir. Backend, iş kurallarını çalıştırarak gerekli işlemleri yapar ve sonuçları frontend'e iletir.

    - Arayüz Açıklaması: RESTful API üzerinden HTTP protokolüyle çalışır. Veri alışverişi JSON formatındadır.

    - Sistem Gereksinimiyle İlişki: Kullanıcı etkileşimini yönetme, görev yönetimi, analiz sunumu gibi temel işlevler bu arayüz aracılığıyla gerçekleştirilir.

- Backend (Spring Boot) ⇄ PostgreSQL Veritabanı Arayüzü

    - İşlevsellik: Veritabanında kullanıcı, proje, görev ve tahmin sonuçları gibi kalıcı verileri saklama ve sorgulama işlemleri yapılır.

    - Arayüz Açıklaması: Spring Data JPA üzerinden JDBC kullanılarak Oracle veritabanına erişim sağlanır.

    - Sistem Gereksinimiyle İlişki: Kalıcı veri yönetimi, kullanıcı oturumlarının tutulması ve görev geçmişinin saklanması gibi sistemsel gereksinimleri karşılar.

- Backend (Spring Boot) ⇄ Makine Öğrenmesi Modülü (Python) Arayüzü

    - İşlevsellik: Görev tamamlama süresi tahmini, ekip yük analizi gibi makine öğrenmesi destekli öneriler sağlar. Backend, verileri bu servise gönderir ve model çıktısını alır.

    - Arayüz Açıklaması: Flask/FastAPI gibi hafif Python framework'leri üzerinden çalışan bir REST servisiyle haberleşir. Veri JSON formatında iletilir.

    - Sistem Gereksinimiyle İlişki: Akıllı öneri sistemi ve analiz desteği gibi gelişmiş özelliklerin temelini oluşturur.

- Kullanıcı (Browser) ⇄ Frontend (Next.js) Arayüzü

    - İşlevsellik: Kullanıcı, tarayıcı üzerinden arayüzle etkileşim kurar. Proje oluşturma, görev atama, analiz görüntüleme gibi işlemleri yapar.

    - Arayüz Açıklaması: Web tarayıcısı üzerinden erişilen React tabanlı kullanıcı arayüzü. HTML, CSS ve JavaScript kullanılarak etkileşimli sayfalar oluşturulmuştur.

    - Sistem Gereksinimiyle İlişki: Kullanılabilirlik, kullanıcı deneyimi ve görsel sunum gibi gereksinimleri karşılar.

- Makine Öğrenmesi (Python) Modülü ⇄ Veri Kaynağı Arayüzü

    - İşlevsellik: Model eğitimi için veri setlerine erişim sağlar. Bu veriler dış kaynaklardan veya sistem içinden sağlanabilir.

    - Arayüz Açıklaması: CSV/JSON gibi veri dosyaları veya backend aracılığıyla gönderilen veri akışı kullanılır.

    - Sistem Gereksinimiyle İlişki: Makine öğrenmesi modelinin eğitilmesi ve güncellenmesi için gereklidir.

#### 2.1.2 Kullanıcı Arayüzleri (User Interfaces)

##### Arayüzün Mantıksal Özellikleri

Aşağıda, kullanıcıların yazılım ile etkileşime geçmesini sağlayacak kullanıcı arayüzünün mantıksal karakteristikleri tanımlanmıştır:

- Ekran Formatları:

    - Kullanıcı, giriş yaptıktan sonra bir ana kontrol paneli (dashboard) ile karşılaşacaktır.

    - Dashboard üzerinde, projelere hızlı erişim, görev durumu özetleri (tamamlanan, süresi yaklaşan vb.), ve takvim görünümü gibi bileşenler yer alacaktır.

- Sayfa / Pencere Düzeni:

    - Görev listeleri, kanban panoları veya liste görünümü olarak sunulacaktır.

    - Sol tarafta projeler ve kategoriler için bir navigasyon menüsü, sağ tarafta görev detayları için bir panel bulunacaktır.

    - Tüm sayfalar, responsive olacak şekilde tasarlanacak ve mobil cihazlarla uyumlu olacaktır.

- Rapor ve Menü İçerikleri:

    - Proje ilerlemesi, kullanıcıya özel görev yükü ve zaman çizelgesi gibi bilgileri içeren PDF/CSV raporları alınabilecektir.

    - Ana menüde: “Projeler”, “Görevler”, “Takvim”, “Takım Üyeleri”, “Ayarlar” gibi alt başlıklar yer alacaktır.

- Fonksiyon Tuşları / Kestirmeler:

    - Klavye kısayolları desteği sunulacaktır (örn. N tuşu ile yeni görev ekleme, Ctrl + Enter ile kaydetme).

    - Sık kullanılan işlemler için özelleştirilebilir araç çubuğu olacaktır.

#####  Son Kullanıcılar için Arayüz Optimizasyonu (Interface Optimization for End Users)

Kullanıcı arayüzü, farklı teknik bilgi seviyelerine sahip kullanıcıların verimli ve hatasız şekilde çalışmasını sağlamak üzere optimize edilecektir:

- Kullanılabilirlik İlkeleri (Do's and Don'ts):

    - Yapılmalı:

        - Arayüz, sade ve dikkat dağıtmayan bir tasarıma sahip olmalı.

        - Renkler, erişilebilirlik standartlarına (WCAG) uygun seçilmeli.

        - Tüm etkileşimli öğeler (butonlar, bağlantılar vb.) etiketlenmeli ve sezgisel yerleştirilmeli.

        - Kullanıcılar yaptıkları işlemlerden sonra sistemden geri bildirim almalı (örneğin, “Görev başarıyla oluşturuldu”).

        - Yardım balonları, bilgi ikonları ve araç ipuçları (tooltips) ile kullanıcı desteklenmeli.

    - Yapılmamalı:

        - Kullanıcıdan aynı bilgiyi birden fazla kez girmesi istenmemeli.

        - Kritik işlemler için onay alınmadan işlem yapılmamalı (örneğin, görev silme).

        - Aşırı bilgi yoğunluğu olan sayfalardan kaçınılmalı.

- Hata Mesajları:

    - Kullanıcılar, ayarlardan kısa veya detaylı hata mesajı seçimi yapabilecek.

        Örnek:

            Kısa: "Hata: Görev oluşturulamadı."

            Detaylı: "Hata: Görev oluşturulamadı. Lütfen tüm zorunlu alanları doldurduğunuzdan emin olun."

- Kullanılabilirlik Gereksinimleri (verifiable):

    - “Bir kullanıcı, uygulama eğitimi sonrası, yeni bir proje oluşturup 5 görev atamasını 3 dakika içinde tamamlayabilmelidir.”

    - “Yeni görev oluşturma işlemi, en fazla 3 adımda tamamlanabilir olmalıdır.”

    - “Bir kullanıcı, projesine ekip arkadaşı ekleme işlemini maksimum 2 dakikada tamamlayabilmelidir.”

#### 2.1.3 Donanım Arayüzü (Hardware Interfaces)

Bu bölüm, yazılım ürününün sistemde yer alan donanım bileşenleri ile olan arayüzlerinin mantıksal karakteristiklerini tanımlar. Bu kapsam, kullanılan cihazların türleri, nasıl desteklenecekleri, gerekli yapılandırma özellikleri ve iletişim protokollerini içerir.

- Supported Hardware Devices
    
    - Yazılım, aşağıdaki donanım bileşenlerini destekleyecektir:

        - Klavye ve Fare (Standard Input Devices): Yazılım, kullanıcıdan veri girişi için tam Q klavye ve standart fare desteğini sağlayacaktır. Özel giriş cihazları gerekmez.


    - Dokunmatik Ekranlar: Yazılım arayüzü, dokunmatik ekranlı cihazlarda çalışmaya uygun olacak şekilde tasarlanmıştır (responsive design ve büyük butonlar).

- Configuration Characteristics
    - Port Gereksinimleri:

        - Yazılım istemcisi ile sunucu arasındaki iletişim HTTPS (TLS) üzerinden 443 numaralı port üzerinden yapılacaktır.

        - Çevre birimleri için ek port yapılandırması gerekmez.

    - Instruction Set / İşlemci Uyumluluğu:

        - Sunucu tarafı uygulama, x86_64 mimarisi destekleyen işlemciler üzerinde çalışmak üzere derlenmiştir.

        - Minimum donanım gereksinimleri:

            - 2 GHz çift çekirdekli işlemci

            - 4 GB RAM

    - Veritabanı Sunucusu ile Entegrasyon:

        - Yazılımın çalışabilmesi için PostgreSQL veya MySQL gibi bir ilişkisel veritabanı sunucusu gereklidir. Bu donanım bileşeni ayrı bir fiziksel makinede de barındırılabilir.

        - Yazılım, TCP/IP protokolü ile veritabanına bağlanacaktır.

- Communication Protocols
    
    - Kullanıcı cihazı ile sunucu arasında:

        - HTTPS (TLS 1.2 ve üzeri) protokolü kullanılacaktır.

        - REST API çağrıları ile veri alışverişi yapılacaktır.

    - Donanım ile arayüzde özel protokol yoktur.

            Örneğin: I/O Cihazları, işletim sisteminin kendi API'leri aracılığıyla kontrol edilecektir; özel sürücü gerekmez.

#### 2.1.4 Yazılım Arayüzü (Software Interfaces)

Bu bölüm, yazılım ürününün gerektirdiği diğer yazılım bileşenlerini ve bu bileşenlerle olan arayüzlerini tanımlar. Yazılım sisteminin çalışabilmesi için kullanılan çerçeveler, veritabanı sistemleri, programlama dilleri ve entegrasyon yazılımları burada tanımlanmıştır.

- Gerekli Yazılım Ürünleri 

| **İsim**       | **Mnemonic** | **Spesifikasyon Numarası** | **Versiyon**    | **Kaynak**                                          |
| -------------- | ------------ | -------------------------- | --------------- | --------------------------------------------------- |
| Next.js        | NEXT         | NEXT-SPEC-001              | 14.x veya üzeri | [nextjs.org](https://nextjs.org)                    |
| React.js       | REACT        | REACT-SPEC-002             | 18.x veya üzeri | [react.dev](https://react.dev)                      |
| Spring Boot    | SPRING       | SPRING-SPEC-003            | 3.x veya üzeri  | [spring.io](https://spring.io/projects/spring-boot) |
| PostgreSQL     | PGSQL        | PGSQL-SPEC-004             | 15.x veya üzeri | [postgresql.org](https://www.postgresql.org)        |
| Python         | PYTHON       | PY-SPEC-005                | 3.10 veya üzeri | [python.org](https://www.python.org)                |
| Docker         | DOCKER       | DOCKER-SPEC-006            | 24.x            | [docker.com](https://www.docker.com)                |
| Ubuntu (Linux) | UBUNTU       | OS-SPEC-007                | 22.04 LTS       | [ubuntu.com](https://ubuntu.com)                    |

- Yazılım Arayüzleri
    1. Next.js (Frontend Framework)
        - Amaç: Web tabanlı kullanıcı arayüzünü sunar ve API istekleri aracılığıyla sunucuya erişim sağlar.

        - Arayüz Tanımı:

            - HTTP üzerinden REST API ya da Next.js App Router kullanılarak veri alışverişi yapılır.

            - JSON veri formatı kullanılır.

            - WebSocket desteği (opsiyonel) ile canlı veri akışı mümkündür.

    2. Spring Boot (Backend API Servisi)
        - Amaç: Veritabanı işlemleri, iş mantığı ve kullanıcı doğrulaması gibi sunucu tarafı süreçlerini yönetir.

        - Arayüz Tanımı:

            - RESTful API standardı üzerinden JSON formatında mesajlaşma sağlar.

            - API endpoint'leri /api/v1/* şeklinde organize edilir.

            - Swagger veya OpenAPI dökümantasyonu ile desteklenir.

            - Örnek API Çağrısı:
                <pre><code>
                POST /api/v1/projects 
                { 
                    "name": "Sprint 1", 
                    "startDate": "2025-07-10", 
                    "ownerId": "u123" 
                } 
                </code></pre>

    3. PostgreSQL (Veri Tabanı Yönetim Sistemi)
        - Amaç: Kalıcı veri depolama sağlar. Tüm kullanıcı, proje, görev ve aktivite verileri burada tutulur.

        - Arayüz Tanımı:

            - Spring Data JPA (Java tarafı) veya psycopg2 (Python tarafı) ile etkileşim kurar.

            - Tablo yapısı:

                users, projects, tasks, comments, activity_logs

            - Veri erişimi için SQL sorguları veya ORM kullanılır.

    4. Python (Arka Plan Hizmetleri / Yapay Zeka / Veri Analizi)
        - Amaç: Zamanlanmış görevler, veri analizi, raporlama veya makine öğrenmesi modüllerini çalıştırmak için kullanılır.

        - Arayüz Tanımı:

            - HTTP üzerinden REST API veya mesaj kuyrukları (örn. RabbitMQ, Redis, Kafka) ile iletişim kurar.

            - Python tarafı arayüzler: Flask, FastAPI veya Celery kullanılabilir.

            - Veri formatı: JSON

            - Örnek:
                <pre><code>
                POST /analyze/task-efficiency
                {
                    "projectId": "p789"
                }
                </code></pre>

    5. Docker (Dağıtım Ortamı)
        - Amaç: Tüm uygulama bileşenlerinin kapsayıcılar (containers) içinde çalışmasını sağlar.

        - Arayüz Tanımı:

            - Docker Compose ile hizmetler tanımlanır:

                frontend, backend, db, worker, nginx

            - Arayüz: CLI komutları (docker build, docker run, docker compose up vs.)

#### 2.1.5 İletişim Arayüzü (Communication Interfaces)

Bu yazılım sistemi, hem istemci-sunucu iletişimi hem de mikro servis bileşenleri arasında veri alışverişini sağlamak için modern iletişim protokollerini ve altyapı teknolojilerini kullanır. Aşağıda kullanılan iletişim arayüzleri belirtilmiştir:

1. HTTP/HTTPS Protokolü
    - Amaç: Web tarayıcısı ile sunucu (Next.js ↔ Spring Boot) arasında güvenli iletişim sağlamak.

    - Kullanım:

        - Next.js frontend uygulaması, RESTful API çağrılarını HTTPS üzerinden backend'e gönderir.

        - Tüm veriler JSON formatında gönderilir/alınır.

    - Standartlar:

        - HTTP/1.1 ve HTTP/2 desteklenir.

        - TLS (HTTPS) ile şifrelenmiş bağlantı.

3. Veritabanı Bağlantısı (PostgreSQL)
    - Amaç: Spring Boot ve Python servislerinin PostgreSQL veritabanına erişimini sağlamak.

    - Kullanım:

        - JDBC (Java Database Connectivity) üzerinden Spring Boot erişimi

        - psycopg2 veya SQLAlchemy üzerinden Python erişimi

    - Protokol: PostgreSQL TCP/IP Protokolü (Port: 5432)

4. İç Servisler Arası İletişim (Backend ↔ Python Services)
    - Amaç: Arka planda çalışan Python servislerinin, Java servisleriyle veri alışverişinde bulunması.

    - Kullanım:

        - RESTful API çağrıları (HTTP/HTTPS üzerinden)

        - Opsiyonel olarak mesaj kuyrukları (RabbitMQ, Redis, Kafka)

        - Veri Formatı: JSON

        - Portlar: 8000 (Python), 8080 (Spring Boot)

5. Docker Ağ Katmanı
    - Amaç: Tüm servislerin (frontend, backend, veritabanı, python worker) kapsayıcılar içinde güvenli ve izole şekilde haberleşmesini sağlamak.

    - Kullanım:

        - Docker Compose ile özel bir sanal ağ tanımlanır (örneğin app_network)

        - Servisler, bu ağ üzerinden DNS adıyla birbirine ulaşır (örn: backend:8080, db:5432)

    - Protokol: TCP/IP (Docker virtual bridge network)

6. Yerel Geliştirme ve Debug Bağlantıları
    - Amaç: Geliştirme sırasında hizmetlerin yerel olarak haberleşmesini sağlamak.

    - Port Örnekleri:

        - Next.js: http://localhost:3000

        - Spring Boot: http://localhost:8080

        - Python API: http://localhost:8000
 

            