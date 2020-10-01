import java.util.*;

class Racing_Game {

    public Racing_Game() {
        start_game();
    }

    private static int roll;
    private static int snake_bite;
    private static int vulture_bite;
    private static int cricket_bite;
    private static int trampolines_count;
    private static int tile_counter;


    public static int getTile_counter() {
        return tile_counter;
    }

    public static void setTile_counter(int tile_counter) {
        Racing_Game.tile_counter = tile_counter;
    }

    public static int getCricket_bite() {
        return cricket_bite;
    }

    public static int getRoll() {
        return roll;
    }

    public static int getSnake_bite() {
        return snake_bite;
    }

    public static int getTrampolines_count() {
        return trampolines_count;
    }

    public static int getVulture_bite() {
        return vulture_bite;
    }

    public static void setCricket_bite(int cricket_bite) {
        Racing_Game.cricket_bite = cricket_bite;
    }

    public static void setRoll(int roll) {
        Racing_Game.roll = roll;
    }

    public static void setSnake_bite(int snake_bite) {
        Racing_Game.snake_bite = snake_bite;
    }

    public static void setTrampolines_count(int trampolines_count) {
        Racing_Game.trampolines_count = trampolines_count;
    }

    public static void setVulture_bite(int vulture_bite) {
        Racing_Game.vulture_bite = vulture_bite;
    }

    void start_game(){
        Scanner scrn = new Scanner(System.in);
        System.out.println("Enter total number of tiles on the race track (length)");
        int no_of_tiles = scrn.nextInt();
        Map start = new Map(no_of_tiles);
        String[] arr = start.map(no_of_tiles);
        System.out.println("Setting up the race track...\n" +
                "Danger: There are " + start.getSnake() + ", " + start.getCricket() + ", " + start.getVulture() + " numbers of Snakes, Cricket, and Vultures respectively on your track!");
        Random_Req random_start = new Random_Req();
        System.out.println("Danger: Each Snake, Cricket, and Vultures can throw you back by " + random_start.snake(no_of_tiles) + ", " + random_start.cricket(no_of_tiles) + ", " + random_start.vulture(no_of_tiles) + " number of Tiles respectively!");
        snake snak = new snake(random_start.snake(no_of_tiles));
        valture vla = new valture(random_start.vulture(no_of_tiles));
        cricket crit = new cricket(random_start.cricket(no_of_tiles));
        Trampoline tramp = new Trampoline(random_start.tamplonie(no_of_tiles));
        System.out.println("Enter the Player Name");
        String name = scrn.next();
        System.out.println("Starting the game with " + name + " at Tile-1\n" +
                "Control transferred to Computer for rolling the Dice for " + name + "\n" +
                "Hit enter to start the game");
        System.out.println("Game Started ======================>");
        boolean f = false;
        while (true) {


                setRoll(getRoll() + 1);
                if (random_start.roller() == 6) {
                    System.out.println("[Roll-" + getRoll() + "]: " + name + " rolled 6 at Tile-1. You are out of the cage! You get a free roll");
                    setRoll(getRoll() + 1);
                    setTile_counter(getTile_counter() + 1);
                    f = true;
                } else if (random_start.roller() != 6 && !f) {
                    System.out.println("[Roll-" + getRoll() + "]: " + name + " rolled " + random_start.roller() + " at Tile-1, OOPs you need 6 to start");

                } else {
                    System.out.println("[Roll-" + getRoll() + "]: " + name + " rolled " + random_start.roller() + " at Tile-" + getTile_counter() + ", landed on Tile " + (getTile_counter() + random_start.roller()) + ".");

                    setTile_counter(getTile_counter() + random_start.roller());
                    System.out.println("Trying to shake the Tile-" + getTile_counter());
                    if (arr[getTile_counter() - 1] == "Snake") {
                        System.out.println(snak.getSnk().getNodeAt(0).sound + " " + random_start.snake(no_of_tiles) + " tiles!");
                        int temp = getTile_counter() - random_start.snake(no_of_tiles);
                        setSnake_bite(getSnake_bite() + 1);
                        if (temp >= 1) {
                            System.out.println(name + " moved to Tile " + temp);
                            setTile_counter(temp);

                        } else {
                            System.out.println(name + " moved to Tile 1 as it can’t go back further");
                            setTile_counter(1);

                        }
                    } else if (arr[getTile_counter() - 1] == "Vulture") {
                        System.out.println(vla.getVul().getNodeAt(0).sound + " " + random_start.vulture(no_of_tiles) + " tiles!");
                        int temp = getTile_counter() - random_start.vulture(no_of_tiles);
                        setVulture_bite(getVulture_bite() + 1);
                        if (temp >= 1) {
                            System.out.println(name + " moved to Tile " + temp);
                            setTile_counter(temp);

                        } else {
                            System.out.println(name + " moved to Tile 1 as it can’t go back further");
                            setTile_counter(1);

                        }

                    } else if (arr[getTile_counter() - 1] == "Cricket") {
                        System.out.println(crit.getCri().getNodeAt(0).sound + " " + random_start.cricket(no_of_tiles) + " tiles!");
                        int temp = getTile_counter() - random_start.cricket(no_of_tiles);
                        setCricket_bite(getCricket_bite() + 1);
                        if (temp >= 1) {
                            System.out.println(name + " moved to Tile " + temp);
                            setTile_counter(temp);

                        } else {
                            System.out.println(name + " moved to Tile 1 as it can’t go back further");
                            setTile_counter(1);

                        }

                    } else if (arr[getTile_counter() - 1] == "Trampoline") {
                        System.out.println(tramp.getTra().getNodeAt(0).sound + " " + random_start.tamplonie(no_of_tiles) + " tiles!");
                        int temp = getTile_counter() + random_start.tamplonie(no_of_tiles);
                        setTrampolines_count(getTrampolines_count() + 1);
                        if (temp > arr.length - 1) {
                            System.out.println(name + " moved to Tile " + (arr.length - 1) + "because you are at the last tile");
                            System.out.println("Josh wins the race in " + getRoll() + " rolls!\n" +
                                    "Total Snake Bites = " + getSnake_bite() + "\n" +
                                    "Total Vulture Bites = " + getVulture_bite() + "\n" +
                                    ">> Total Cricket Bites = " + getCricket_bite() + "\n" +
                                    ">> Total Trampolines = " + getTrampolines_count() + "");
                            setTile_counter(arr.length - 1);
                            break;


                        } else {
                            System.out.println(name + " moved to Tile " + temp + "");
                            setTile_counter(temp);

                        }

                    } else if (arr[getTile_counter() - 1] == "White") {
                        System.out.println("I am a White tile!\n" + "" + name + "moved to Tile-" + getTile_counter() + "");

                    }


                }
                if (getTile_counter() == (arr.length - 1)) {
                    System.out.println("Josh wins the race in " + getRoll() + " rolls!\n" +
                            "Total Snake Bites = " + getSnake_bite() + "\n" +
                            "Total Vulture Bites = " + getVulture_bite() + "\n" +
                            ">> Total Cricket Bites = " + getCricket_bite() + "\n" +
                            ">> Total Trampolines = " + getTrampolines_count() + "");
                    break;

                }


        }
        return;


    }

     void snakemessage() throws SnakebiteException{
        throw new SnakebiteException("Hiss...! I am a Snake");
    }

     void vulturemessage() throws VulturebiteException{
        throw new VulturebiteException("Yapping...! I am a Vulture, you go back");
    }
     void cricketmessage() throws CricketbiteException{
        throw new CricketbiteException("Chirp...! I am a Cricket, you go back");
    }
     void tampmessage() throws TrampolineException{
        throw new TrampolineException("PingPong! I am a Trampoline, you advance");
    }
    void winnermessage() throws GameWinnerException{
        throw new GameWinnerException("Game Winner");
    }




    class snake extends Obstacles implements game {
        private Obstacles snk = new Obstacles();

        public snake(int random) {
            snake(random);
        }

        public Obstacles getSnk() {
            return snk;
        }

        public void setSnk(Obstacles snk) {
            this.snk = snk;
        }

        void snake(int random) {
            getSnk().addFirst("Snake", random, "Hiss...! I am a Snake, you go back");
        }
        @Override
        public int attack(int random) {
            int helper = snk.getNodeAt(0).Random_number;

            return helper;
        }
    }

    class valture extends Obstacles implements game {
        private Obstacles vul = new Obstacles();

        public valture(int random) {
            vulture(random);
        }

        public Obstacles getVul() {
            return vul;
        }

        public void setVul(Obstacles vul) {
            this.vul = vul;
        }

        void vulture(int random) {
            getVul().addFirst("Vulture", random, "Yapping...! I am a Vulture, you go back");
        }

        @Override
        public int attack(int random) {
            int helper = vul.getNodeAt(0).Random_number;

            return helper;
        }

    }

    class cricket extends Obstacles implements game {

        public cricket(int random) {
            cricket(random);
        }

        private Obstacles cri = new Obstacles();

        public Obstacles getCri() {
            return cri;
        }

        public void setCri(Obstacles cri) {
            this.cri = cri;
        }

        void cricket(int random) {
            getCri().addFirst("Cricket", random, "Chirp...! I am a Cricket, you go back");
        }
        @Override
        public int attack(int random) {
            int helper = cri.getNodeAt(0).Random_number;

            return helper;
        }
    }

    class Trampoline extends Obstacles implements game {
        private Obstacles tra = new Obstacles();

        public Trampoline(int random) {
            trampolie(random);
        }

        public Obstacles getTra() {
            return tra;
        }

        public void setTra(Obstacles tra) {
            this.tra = tra;
        }

        void trampolie(int random) {
            tra.addFirst("Trampoline", random, "PingPong! I am a Trampoline, you advance");

        }

        @Override
        public int attack(int random) {
            int helper = tra.getNodeAt(0).Random_number;
            
            return helper;
        }
    }

    class Random_Req {
        private int[] dice = {1, 2, 3, 4, 5, 6};

        public int[] getDice() {
            return dice;
        }

        public void setDice(int[] dice) {
            this.dice = dice;
        }

        int roller() {
            Random random_idx = new Random();
            int randomNumber = random_idx.nextInt(getDice().length);
            return getDice()[randomNumber];
        }

        int snake(int total) {
            int snake = total / 10;
            int[] arr = new int[snake];
            for (int i = 1; i <= snake; i++) {
                arr[i - 1] = i;
            }
            Random random_idx = new Random();
            int randomNumber = random_idx.nextInt(snake);
            return arr[randomNumber];

        }

        int vulture(int total) {
            int vulture = total / 10;
            int[] arr = new int[vulture];
            for (int i = 1; i <= vulture; i++) {
                arr[i - 1] = i;
            }
            Random random_idx = new Random();
            int randomNumber = random_idx.nextInt(vulture);
            return arr[randomNumber];

        }

        int cricket(int total) {
            int cricket = total / 10;
            int[] arr = new int[cricket];
            for (int i = 1; i <= cricket; i++) {
                arr[i - 1] = i;
            }
            Random random_idx = new Random();
            int randomNumber = random_idx.nextInt(cricket);
            return arr[randomNumber];

        }

        int tamplonie(int total) {
            int tamp = total / 10;
            int[] arr = new int[tamp];
            for (int i = 1; i <= tamp; i++) {
                arr[i - 1] = i;
            }
            Random random_idx = new Random();
            int randomNumber = random_idx.nextInt(tamp);
            return arr[randomNumber];

        }

    }


    class Map {
        private int snake;
        private int vulture;
        private int cricket;
        private int tampr;

        public Map(int total) {
            map(total);
        }

        public int getCricket() {
            return cricket;
        }

        public int getSnake() {
            return snake;
        }

        public int getTampr() {
            return tampr;
        }

        public int getVulture() {
            return vulture;
        }

        public void setCricket(int cricket) {
            this.cricket = cricket;
        }

        public void setSnake(int snake) {
            this.snake = snake;
        }

        public void setTampr(int tampr) {
            this.tampr = tampr;
        }

        public void setVulture(int vulture) {
            this.vulture = vulture;
        }

        String[] map(int total) {
            String[] map = new String[total];
            Arrays.fill(map, "White");
            int lim = total / 10;
            int[] arr = new int[lim];
            for (int i = 1; i <= lim; i++) {
                arr[i - 1] = i;
            }
            Random random = new Random();
            int snk = random.nextInt(arr.length);
            int vul = random.nextInt(arr.length);
            int cri = random.nextInt(arr.length);
            int tamp = random.nextInt(arr.length);
            setSnake(snk);
            setVulture(vul);
            setCricket(cri);
            setTampr(tamp);
            int snk_counter = 0;
            int vul_counter = 0;
            int cri_counter = 0;
            int tamp_counter = 0;

            while (snk_counter < snk) {
                Random random_idx = new Random();
                int randomNumber = random_idx.nextInt(map.length);
                if (randomNumber == 0 || randomNumber == map.length - 1) {
                    continue;
                }
                map[randomNumber] = "Snake";
                snk_counter++;
            }
            while (vul_counter < vul) {
                Random random_idx = new Random();
                int randomNumber = random_idx.nextInt(map.length);
                if (randomNumber == 0 || randomNumber == map.length - 1) {
                    continue;
                }
                map[randomNumber] = "Vulture";
                vul_counter++;
            }
            while (cri_counter < cri) {
                Random random_idx = new Random();
                int randomNumber = random_idx.nextInt(map.length);
                if (randomNumber == 0 || randomNumber == map.length - 1) {
                    continue;
                }
                map[randomNumber] = "Cricket";
                cri_counter++;
            }
            while (tamp_counter < tamp) {
                Random random_idx = new Random();
                int randomNumber = random_idx.nextInt(map.length);
                if (randomNumber == 0 || randomNumber == map.length - 1) {
                    continue;
                }
                map[randomNumber] = "Trampoline";
                tamp_counter++;
            }
            Collections.shuffle(Arrays.asList(map));
            map[0] = "White";
            map[map.length - 1] = "White";
            return map;
        }
    }


    class Obstacles {
        private class Node {
            Node next;
            String name;
            String sound;
            int Random_number;

            public Node(String name, int Random_number, String sound, Node next) {
                this.name = name;
                this.Random_number = Random_number;
                this.sound = sound;
                this.next = next;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int getSize() {
            return this.size;
        }

        public void addFirst(String name, int Random_number, String sound) {
            Node nn = new Node(name, Random_number, sound, null);
            nn.next = this.head;
            if (size == 0) {
                this.head = nn;
                this.tail = nn;
                this.size++;
            } else {
                this.head = nn;
                this.size++;
            }
        }

        private Node getNodeAt(int idx) {

            Node temp = this.head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        Racing_Game new_game = new Racing_Game();
    }
    class GameWinnerException extends Exception{
        public GameWinnerException(String message){
            super(message);

        }

    }
    class SnakebiteException extends Exception{
        public SnakebiteException(String message){
            super(message);

        }

    }
    class CricketbiteException extends Exception{
        public CricketbiteException(String message){
            super(message);

        }

    }
    class VulturebiteException extends Exception{
        public VulturebiteException(String message){
            super(message);

        }

    }
    class TrampolineException extends Exception{
        public TrampolineException(String message){
            super(message);

        }

    }
    interface game{
        int attack(int random);
    }
}