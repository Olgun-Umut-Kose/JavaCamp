package com.bgouk;

public class StudentManager extends UserManager{

    //bu gördüğümüz metot override extends edilen sınıfın metodu geçersiz kılınıp bu sınıfa özgü bir işlem gerçekleştirme işlemi
    //gördüğünüz gibi burda imza dediğimiz "public void commonOperationOne(User <name>)" kısmı değiştiremiyoruz hadi gelin değiştirdiğimizde ne olduğuna bakalım
    @Override
    public void commonOperationOne(User user) {
        System.out.println("Ortak operasyon 1 instructor dan çalştı");
    }

    //gördüğünüz gibi başında @Override yok koyarsak hata alırız peki override da imza değişmiyordu bu yaptığımız işlem ne
    //bu yaptığımız işlemin adı metot overloading metot aşırı yüklemesi bu işlem ne yapar
    //şuan burda görmeseniz bile extends edilen sınıftan commonOperationOne metotdu geliyor aynı isimde ama farklı parametrelerde metot oluşturursak metodu aşırı yüklemiş oluruz
    //bunun sonucunda da StudentManager sınıfında 2 adet commonOperationOne metotu olmuş oldu biri User tipinde bir parametre beklerken diğeri Student tipinde bir parametre bekliyor olacaktır
    //ödevde kampta öğrendiğinizin dışına çıkmayın dendiği için override ettiğimizde StudentManagerda Instructor işlemleri yapabilme gibi bi sorun ile karşılaşıyoruz
    //interface ve generic yapıları kullanmadan burda bir base yapı kurmamız imkansızdır
    public void commonOperationOne(Student student) {
        System.out.println("Ortak operasyon 1 student dan çalştı");
    }


    @Override
    public void commonOperationTwo(User user) {
        System.out.println("Ortak operasyon 2 instructor dan çalştı");
    }
    public void commonOperationTwo(Student student) {
        System.out.println("Ortak operasyon 2 student dan çalştı");
    }

    @Override
    public void commonOperationThree(User user) {
        System.out.println("Ortak operasyon 3 instructor dan çalştı");
    }
    public void commonOperationThree(Student student) {
        System.out.println("Ortak operasyon 3 student dan çalştı");
    }

    public void specificOperation(Student student){
        System.out.println("student özel operasyon çalıştı");
    }



}
