package take.beans;
public class ColorBean {
 private String foregroundColor;
 private String backgroundColor;
 private Boolean hasBorder;

 public ColorBean() {
 }

    /**
     * @return the foregroundColor
     */
    public String getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @param foregroundColor the foregroundColor to set
     */
    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * @return the backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the hasEdges
     */
    public Boolean getHasBorder() {
        return hasBorder;
    }

    /**
     * @param hasEdges the hasEdges to set
     */
    public void setHasBorder(Boolean hasBorder) {
        this.hasBorder = hasBorder;
    }
}