package com.bgouk;

public class StudentManager extends UserManager{

    //bu gördüğümüz metot overrideing extends edilen sınıfın metodu geçersiz kılınıp bu sınıfa özgü bir işlem gerçekleştirme işlemi
    //gördüğünüz gibi burda imza dediğimiz "public void signIn(User <name>)" kısmı değiştiremiyoruz hadi gelin değiştirdiğimizde ne olduğuna bakalım
    @Override
    public void signIn(User user) {
        System.out.println(user.getFirtName() + " isimli öğrenci giriş yaptı");
    }

    //gördüğünüz gibi başında @Override yok koyarsak hata alırız peki override da imza değişmiyordu bu yaptığımız işlem ne
    //bu yaptığımız işlemin adı metot overloading metot aşırı yüklemesi bu işlem ne yapar
    //şuan burda görmeseniz bile extends edilen sınıftan signIn metotdu geliyor aynı isimde ama farklı parametrelerde metot oluşturursak metodu aşırı yüklemiş oluruz
    //bunun sonucunda da InstructorManager sınıfında 2 adat signIn metotu olmuş oldu biri User tipinde bir parametre beklerken diğeri Student tipinde bir parametre bekliyor olacaktır
    //ödevde kampta öğrendiğinizin dışına çıkmayın dendiği için override ettiğimizde StudentManagerda Instructor işlemleri yapabilme gibi bi sorun ile karşılaşıyoruz
    //interface ve generic yapıları kullanmadan burda bir base yapı kurmamız imkansızdır
    public void signIn(Student student) {
        System.out.println(student.getFirtName() + " isimli öğrenci giriş yaptı");
    }

    @Override
    public void signOut(User user) {
        System.out.println(user.getFirtName() + " isimli öğrenci çıkış yaptı");
    }

    public void signOut(Student student) {
        System.out.println(student.getFirtName() + " isimli öğrenci çıkış yaptı");
    }

    @Override
    public void signUp(User user) {
        System.out.println(user.getFirtName() + " isimli öğrenci kayıt oldu");
    }
    public void signUp(Student student) {
        System.out.println(student.getFirtName() + " isimli öğrenci kayıt oldu");
    }

    public void registerCourse(Student student){
        System.out.println("sayın " + student.getFirtName() + " kursa kaydınız başarıyla gerçekleştirilmiştir");
    }
}
