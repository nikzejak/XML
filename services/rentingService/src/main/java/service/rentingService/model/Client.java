package service.rentingService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(name = "jmbg", unique = true, nullable = false)
    private String jmbg;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    //agent
    @Column(nullable = true)
    private String personalID;
    //firma
    @Column(nullable = true)
    private String pib;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Ad> ads;

    @Column(nullable = false)
    private int adCounter;

    @Column()
    private boolean allowReservation = true;

    @Column()
    private int reservationCanceledCounter;


    public Client() {
    }

    //endUser
    public Client(String email,String password,String firstName,String lastName,String jmbg,String phoneNumber,String address) {
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.jmbg=jmbg;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.role=Role.ENDUSER;
        this.adCounter = 0;
        this.allowReservation = true;
        this.reservationCanceledCounter = 0;
    }

    //agent
    public Client(String email,String password,String firstName,String lastName,String jmbg,String phoneNumber,String address,String personalID) {
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.jmbg=jmbg;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.personalID=personalID;
        this.role=Role.AGENT;
        this.adCounter = 0;
    }

    //firm
    public Client(String email,String password,String firstName,String phoneNumber,String address,String pib) {
        this.email=email;
        this.firstName=firstName;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.pib=pib;
        this.role=Role.FIRM;
        this.adCounter = 0;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdCounter() {
        return adCounter;
    }

    public void setAdCounter(int adCounter){}

    public boolean isAllowReservation() {
        return allowReservation;
    }

    public void setAllowReservation(boolean allowReservation) {
        this.allowReservation = allowReservation;
    }

    public int getReservationCanceledCounter() {
        return reservationCanceledCounter;
    }

    public void setReservationCanceledCounter(int reservationCanceledCounter) {
        this.reservationCanceledCounter = reservationCanceledCounter;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", personalID='" + personalID + '\'' +
                ", pib='" + pib + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", ads=" + ads +
                ", adCounter=" + adCounter +
                '}';
    }
}
