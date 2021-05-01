package com.bgouk;

public class InstructorManager extends UserManager{

    //bu gördüğümüz metot overrideing extends edilen sınıfın metodu geçersiz kılınıp bu sınıfa özgü bir işlem gerçekleştirme işlemi
    //gördüğünüz gibi burda imza dediğimiz "public void signIn(User <name>)" kısmı değiştiremiyoruz hadi gelin değiştirdiğimizde ne olduğuna bakalım
    @Override
    public void signIn(User user) {
        System.out.println(user.getFirtName() + " isimli eğitmen giriş yaptı");
    }

    //gördüğünüz gibi başında @Override yok koyarsak hata alırız peki override da imza değişmiyordu bu yaptığımız işlem ne
    //bu yaptığımız işlemin adı metot overloading metot aşırı yüklemesi bu işlem ne yapar
    //şuan burda görmeseniz bile extends edilen sınıftan signIn metotdu geliyor aynı isimde ama farklı parametrelerde metot oluşturursak metodu aşırı yüklemiş oluruz
    //bunun sonucunda da InstructorManager sınıfında 2 adat signIn metotu olmuş oldu biri User tipinde bir parametre beklerken diğeri Instructor tipinde bir parametre bekliyor olacaktır
    //ödevde kampta öğrendiğinizin dışına çıkmayın dendiği için override ettiğimizde InstructorManagerda Student işlemleri yapabilme gibi bi sorun ile karşılaşıyoruz
    //interface ve generic yapıları kullanmadan burda bir base yapı kurmamız imkansızdır
    public void signIn(Instructor instructor) {
        System.out.println(instructor.getFirtName() + " isimli eğitmen giriş yaptı");
    }

    @Override
    public void signOut(User user) {
        System.out.println(user.getFirtName() + " isimli eğitmen çıkış yaptı");
    }

    public void signOut(Instructor instructor) {
        System.out.println(instructor.getFirtName() + " isimli eğitmen çıkış yaptı");
    }

    @Override
    public void signUp(User user) {
        System.out.println(user.getFirtName() + " isimli eğitmen kayıt oldu");
    }
    public void signUp(Instructor instructor) {
        System.out.println(instructor.getFirtName() + " isimli eğitmen kayıt oldu");
    }

    public void addCourse(Instructor instructor){
        System.out.println("sayın " + instructor.getFirtName() + " kursunuz başarı ile sisteme eklenmiştir");
    }



}
