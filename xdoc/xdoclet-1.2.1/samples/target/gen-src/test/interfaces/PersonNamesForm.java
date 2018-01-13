package test.interfaces;

/**
 * Generated by XDoclet/ejbdoclet/strutsform. This class can be further processed with XDoclet/webdoclet/strutsconfigxml.
 *
 * @struts.form name="person.Names"
 */
public class PersonNamesForm
    extends    org.apache.struts.action.ActionForm
    implements java.io.Serializable
{
    protected java.lang.String name;
    protected java.lang.String firstName;
    protected java.lang.String computedField;

    /** Default empty constructor. */
    public PersonNamesForm() {}

    /** Constructor that takes the data object as argument. */
    public PersonNamesForm(test.interfaces.PersonData dataHolder)
    {
       this.setName(dataHolder.getName());
       this.setFirstName(dataHolder.getFirstName());
    }

    public java.lang.String getName()
    {
        return this.name;
    }

    public void setName( java.lang.String name )
    {
        this.name = name;
    }

    public java.lang.String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName( java.lang.String firstName )
    {
        this.firstName = firstName;
    }

    public java.lang.String getComputedField()
    {
        return this.computedField;
    }

    public void setComputedField( java.lang.String computedField )
    {
        this.computedField = computedField;
    }

    public test.interfaces.PersonData getData(test.interfaces.PersonData dataHolder)
    {
       test.interfaces.PersonData retData = new test.interfaces.PersonData(dataHolder);

        retData.setName(this.getName());
        retData.setFirstName(this.getFirstName());

        return retData;
    }

    public test.interfaces.PersonData getData()
    {
       test.interfaces.PersonData retData = new test.interfaces.PersonData();

        retData.setName(this.getName());
        retData.setFirstName(this.getFirstName());

        return retData;
    }

    public void setData(test.interfaces.PersonData dataHolder)
    {
        this.setName (dataHolder.getName());
        this.setFirstName (dataHolder.getFirstName());
    }

}