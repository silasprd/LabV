package tdd.exercice.Triangle;

public class Triangle {
    
    private Integer hypotenuse;
    private Integer catetoA;
    private Integer catetoB;

    public Triangle(Integer hypotenuse, Integer catetoA, Integer catetoB) {
        this.hypotenuse = hypotenuse;
        this.catetoA = catetoA;
        this.catetoB = catetoB;
    }

    public Integer getHypotenuse() {
        return hypotenuse;
    }

    public void setHypotenuse(Integer hypotenuse) {
        this.hypotenuse = hypotenuse;
    }

    public Integer getCatetoA() {
        return catetoA;
    }

    public void setCatetoA(Integer catetoA) {
        this.catetoA = catetoA;
    }

    public Integer getCatetoB() {
        return catetoB;
    }

    public void setCatetoB(Integer catetoB) {
        this.catetoB = catetoB;
    }

    public boolean isValidTriangle() {
        if(hypotenuse <= 0 || catetoA <= 0 || catetoB <= 0)
            return false;
        else if(hypotenuse + catetoA <= catetoB || hypotenuse + catetoB <= catetoA || catetoA + catetoB <= hypotenuse)
            return false;
            
        return true;
    }

    public String getType(){
        if(hypotenuse.equals(catetoA) && catetoA.equals(catetoB))
            return "Equilateral";
        else if (hypotenuse.equals(catetoA) || catetoA.equals(catetoB) || hypotenuse.equals(catetoB))
            return "Isosceles";
        else 
            return "Scalene";
    }

}
