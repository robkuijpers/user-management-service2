package com.kuijpers.demo.jpa.usermngt.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;

/**
 * TODO: encrypt password
 */
@Entity
public class Account {

    private static final Logger log = LoggerFactory.getLogger(Account.class);

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String userName;

    private String password;
    private String confirmCode;
    private Boolean blocked;
    private Boolean confirmed;
    private Boolean deleted;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    private Date confirmDate;

    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name="profile_id")
    private Profile profile;

    protected Account() {}

    /**
     *
     * @param userName
     * @param password
     */
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", creationDate=" + creationDate +
                ", confirmed=" + confirmed +
                ", confirmCode='" + confirmCode + '\'' +
                ", confirmDate=" + confirmDate +
                ", blocked=" + blocked +
                ", deleted=" + deleted +
                '}';
    }
}
