package pl.coderslab.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Tweet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 140, message="Wiadomość może mieć do 140 znaków.")
	private String text;
	private LocalDateTime created;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "tweet_id")
	private Collection<Comment> comments;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Tweet [id=" + id + ", text=" + text + ", created=" + created + ", user=" + user + "]";
	}
	
}
