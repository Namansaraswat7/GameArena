package lld.game.entity;

public class Player {

    private Integer id;
    private String name;
    private int health;
    private int strength;
    private int attack;
    private boolean turn;

    public Player(Integer id, String name, int health, int strength, int attack) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }
    public Player(Integer id,String name) {
        this.id = id;
        this.name = name;
        this.health = 0;
        this.strength = 0;
        this.attack = 0;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean getTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
}
