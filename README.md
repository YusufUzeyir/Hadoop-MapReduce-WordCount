# Hadoop-MapReduce-WordCount


### Run Locally

localhost:9870/explorer.html#/ adresine gidin:

input_dir adında bir dosya oluşturuyoruz:

```bash
hadoop fs -mkdir /input_dir
```

document klasörü içindeki txt dosyalarını(datastimiz) input_dir'in içine atıyoruz:

```bash
hadoop fs -put C:/Users/ASUS/Desktop/document/* /input_dir
```

projenin bulunduğu dizine gidiyoruz (kendi yolunuzu girin bendeki bu şekilde):

```bash
cd C:\Users\ASUS\Desktop\Klasorler\Projeler\JavaProjeleri\wordCount
```

input_dir dosyasındaki verileri projede işleyerek output dosyasında çıktı olarak alıyoruz:

```bash
hadoop jar target/wordCount-1.0-SNAPSHOT.jar org.uzeyir.WC_Runner /input_dir /output
```
