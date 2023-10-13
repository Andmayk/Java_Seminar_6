public class Laptop {
    private String firm;
    private int ram;
    private int hdd;
    private String os;
    private String color;

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void clear() {
        this.ram = 0;
        this.hdd = 0;
        this.firm ="";
        this.os = "";
        this.color = "";
    }

    public String toString(){
        return "Фирма: " + firm + ", RAM: " + ram + ", HDD: " + hdd + ", OС: " + os+ ", цвет: " + color;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Laptop)){
            return false;
        }
        Laptop laptop = (Laptop) obj;
        return firm.equals(laptop.firm) && ram == laptop.ram && hdd == laptop.hdd
                && os.equals(laptop.os) && color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return firm.hashCode() + 7*ram + 13*hdd + 17*os.hashCode() + 19*color.hashCode();
    }
}
