public class ObjectSpace
{
    PhysObject o;
    //constructors
    public ObjectSpace()
    {
       o = null; 
    }
    public ObjectSpace(PhysObject ob)
    {
        o = ob;
    }
    //object controls
    public void changeObject(PhysObject ob)
    {
        o = ob;
    }
    public void clearSpace()
    {
        o = null;
    }
    public boolean isObjNull()
    {
        if(o == null) return true;
        return false;
    }
    public String getObjCommand()
    {
        return o.move();
    }
    public PhysObject getObj()
    {
        return o;
    }
    public String getObjName()
    {
        if(isObjNull()) return "nothing";
        return o.getName();
    }
    public String getObjArticle()
    {
        if(isObjNull()) return "";
        return o.getArticle();
    }
    //toString
    public String toString()
    {
        if(o != null)
        {
            return "" + o.getRep();
        }
        return "";
    }
}