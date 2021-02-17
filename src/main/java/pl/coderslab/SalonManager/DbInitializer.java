//package pl.coderslab.SalonManager;
//
//import lombok.AllArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import pl.coderslab.SalonManager.model.MyService;
//import pl.coderslab.SalonManager.model.User;
//import pl.coderslab.SalonManager.repository.MyServiceRepository;
//import pl.coderslab.SalonManager.repository.UserRepository;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class DbInitializer implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final MyServiceRepository myServiceRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) {
//        this.userRepository.deleteAll();
//
//        User admin = new User("Lukasz", "Bulka", "lukas.bulka@op.pl", passwordEncoder.encode("123"), "ADMIN", "");
//        User employee = new User("Natasha", "Romanov", "blackwidow@avengers.com", passwordEncoder.encode("123"), "EMPLOYEE", "");
//        User user = new User("Tony", "Stark", "ironman@avengers.com", passwordEncoder.encode("123"), "USER", "");
//
//        List<User> users = Arrays.asList(admin, employee, user);
//        this.userRepository.saveAll(users);
//
//
//        this.myServiceRepository.deleteAll();
//        MyService myService1 = new MyService("Mycie włosów", "5", "PLN");
//        MyService myService2 = new MyService("Strzyżenie Męskie", "18", "PLN");
//        MyService myService3 = new MyService("Strzyżenie Damskie: włosy krótkie", "20","PLN");
//        MyService myService4 = new MyService("Strzyżenie Damskie: włosy średnie", "25", "PLN");
//        MyService myService5 = new MyService("Strzyżenie Damskie: włosy długie", "30", "PLN");
//        MyService myService6 = new MyService("Modelowanie plus strzyżenie: włosy krótkie", "45", "PLN");
//        MyService myService7 = new MyService("Modelowanie plus strzyżenie: włosy średnie",  "50", "PLN");
//        MyService myService8 = new MyService("Modelowanie plus strzyżenie: włosy długie", "55", "PLN");
//        MyService myService9 = new MyService("Modelowanie: włosy krótkie", "30", "PLN");
//        MyService myService10 = new MyService("Modelowanie: włosy średnie", "35", "PLN");
//        MyService myService11 = new MyService("Modelowanie: włosy długie", "45", "PLN");
//        MyService myService12 = new MyService("Upięcia", "40-70", "PLN");
//        MyService myService13 = new MyService("Koloryzacja: włosy krótkie", "90", "PLN");
//        MyService myService14 = new MyService("Koloryzacja: włosy średnie", "110", "PLN");
//        MyService myService15 = new MyService("Koloryzacja: włosy długie", "130", "PLN");
//        MyService myService16 = new MyService("Rozjaśnienie plus koloryzacja: włosy krótkie", "130", "PLN");
//        MyService myService17 = new MyService("Rozjaśnienie plus koloryzacja: włosy średnie", "150", "PLN");
//        MyService myService18 = new MyService("Rozjaśnienie plus koloryzacja: włosy długie", "180", "PLN");
//        MyService myService19 = new MyService("Pasemka: włosy krótkie", "100", "PLN");
//        MyService myService20 = new MyService("Pasemka: włosy średnie", "120", "PLN");
//        MyService myService21 = new MyService("Pasemka: włosy długie", "140", "PLN");
//        MyService myService22 = new MyService("Tonowanie po pasemkach", "30-40", "PLN");
//        MyService myService23 = new MyService("Trwała ondulacja: włosy krótkie", "90", "PLN");
//        MyService myService24 = new MyService("Trwała ondulacja: włosy średnie", "110", "PLN");
//        MyService myService25 = new MyService("Trwała ondulacja: włosy długie", "140", "PLN");
//        MyService myService26 = new MyService("Prostowanie włosów", "25", "PLN");
//        MyService myService27 = new MyService("Modelowanie plus prostowanie", "40", "PLN");
//        MyService myService28 = new MyService("Loki z prostownicy: włosy średnie", "40", "PLN");
//        MyService myService29 = new MyService("Loki z prostownicy: włosy długie", "60", "PLN");
//        MyService myService30 = new MyService("Regeneracja włosów", "20", "PLN");
//        MyService myService31 = new MyService("Ultradźwięki", "30", "PLN");
//        MyService myService32 = new MyService("Stymulacja porost włosa", "15", "PLN");
//        MyService myService33 = new MyService("Sauna plus ampułka", "40", "PLN");
//        MyService myService34 = new MyService("Witaminka", "8", "PLN");
//        MyService myService35 = new MyService("Odświeżanie koloru szamponem", "8", "PLN");
//        MyService myService36 = new MyService("Przedłużanie włosów 1 pasemko", "16", "PLN");
//        MyService myService37 = new MyService("Ściąganie włosów 1 pasemko", "4", "PLN");
//
//        List<MyService> myServices = Arrays.asList(myService1, myService2, myService3, myService4, myService5, myService6, myService7, myService8, myService9, myService10,
//                myService11, myService12, myService13, myService14, myService15, myService16, myService17, myService18, myService19, myService20,
//                myService21, myService22, myService23, myService24, myService25, myService26, myService27, myService28, myService29, myService30,
//                myService31, myService32, myService33, myService34, myService35, myService36, myService37);
//        this.myServiceRepository.saveAll(myServices);
//    }
//}