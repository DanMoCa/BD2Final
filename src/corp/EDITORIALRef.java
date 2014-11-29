package corp;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class EDITORIALRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PUBS.EDITORIAL";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final EDITORIALRef _EDITORIALRefFactory = new EDITORIALRef();

  public static ORADataFactory getORADataFactory()
  { return _EDITORIALRefFactory; }
  /* constructor */
  public EDITORIALRef()
  {
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _ref;
  }

  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    EDITORIALRef r = new EDITORIALRef();
    r._ref = (REF) d;
    return r;
  }

  public static EDITORIALRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (EDITORIALRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to EDITORIALRef: "+exn.toString()); }
  }

  public EDITORIAL getValue() throws SQLException
  {
     return (EDITORIAL) EDITORIAL.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(EDITORIAL c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
