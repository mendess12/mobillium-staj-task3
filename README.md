# mobillium-staj-task3

### Konu

<pre> UI state'in korunması, Lifecycle ve LiveData </pre>

Bu kapsamda,

  1-ViewModel, Fragment, Fragment View ve Activity lifecycle'larını,<br>
  2-UI controller (activity, fragment) ile UI datasını yöneten ViewModel'ın sorumluluklarını,<br>
  3-Konfigürasyon değişikliklerinden datayı korumayı,<br>
  4-LiveData, MutableLiveData, Observer, LifecycleOwner, lifecycle-aware gibi kavramları<br>
  5-SharedViewModel (activity) kullanımı ve daha fazlasını öğreneceksin.
  
  <hr>
  
### ViewModel & LiveData dependencies

<pre>
 implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
 implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1"
</pre>

<hr>

### Navigation component dependencies

<pre>
- build.gradle (:app)

dependencies {
    def nav_version = "2.5.3"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
}<br>
plugins{
 id 'androidx.navigation.safeargs.kotlin'
 }
<hr> 
- build.gradle(project) 

 dependencies {
        def nav_version = "2.5.3"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
</pre>

<hr>  

### Hedef

1-Öncelik yeni bir fragment oluşturalım. Bu fragment'a ait ViewModel'ı oluşturalım.(gerekli dependency'leri eklemeyi unutma). Fragment'a ViewModel'ı bağlayalım     (fragment-ktx: by viewModels()). Fragment layout'unda bir TextView ve bir Button olsun. TextView'ımız sayaç numarasını gösterecek, buton ise sayacı arttıracak. Fragment içerisinde tutulan bir global değişken sayaç değerini tutacak. Başlangıç değeri 0. Butona tıklayıp, sayaç değerini arttırdıktan sonra emulatör ya da cihazı rotate edip, sayaç değerinin son değerini koruyup korumadığına bakalım. Aynı senaryoyu bir de ViewModel içerisinde tutacağımız bir değişkene yapalım. TextView'a viewmodel değişkeninin değerini basalım ve değeri tıklama ile değiştirdikten sonra cihazı rotate edip, değerin korunup korunmadığını kontrol edelim. UI'daki gibi bir switch ekleyip, viewmodel ile ui controller değişkeni arasında geçiş yapabiliriz.

2-Bu sefer bir sayı tahmin oyunu yapalım. Yeni bir fragment ve ona bağlı bir viewmodel oluşturalım. Görseldeki gibi basit bir UI yeterli ama daha güzel yaparım dersen, top sende. ViewModel oluştuğunda oyun başlayacak ve bir random sayı üretilecek. Bu sayıyı gizlemek için bu sayıya bağlı bir de random char üretilecek. Ekrana random char'ı basacağız ve kullanıcıdan sayı butonlarına tıklayıp, tahminde bulunmak için "Guess" butonuna basmasını bekleyeceğiz. Guess butonuna basınca, basılan sayı ile random oluşturulmuş olan sayının eşleşmesini kontrol edeceğiz. Oyun esnasında cihazımızı rotate edip, UI state'in korunup, korunmadığına bakabiliriz. Eşleşme varsa, "Kazandın" yoksa; "Tekrar dene" gibi bir sonuç text'i basalım. Kendince iyileştirmeler yapabilirsin; mesela, kazandığında harf yerine sayıyı göstermek gibi. Yalnız viewmodel ve view controller hakkında okuduklarını unutma.

3-Şimdi bir de bir detay fragment oluşturalım. Burada sadece gizlenmiş sayıyı gösteren bir TextView olması yeterli. İlk ekrandaki gizli sayıya (harfe) tıklanınca bu ekrana navigate edelim (ister Navigation Component kullanan, ister fragment manager). Navigate ederken veriyi de bir ortak viewmodel'da tutalım [activityViewModels()]. İki fragment da bu shared viewmodel'ı kullanıyor olacak.

<hr>

### Kaynaklar

- https://developer.android.com/guide/fragments/lifecycle
- https://developer.android.com/guide/components/activities/activity-lifecycle
- https://developer.android.com/topic/libraries/architecture/viewmodel
- https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-apis
- https://developer.android.com/topic/libraries/architecture/livedata
- https://developer.android.com/topic/libraries/architecture/lifecycle

<hr>

#### Konu hakkında hazırladığım raporlar <br>
- https://drive.google.com/drive/u/0/folders/140w6knuKKnjA8mhzEIarjcy-xBPLm3ne
