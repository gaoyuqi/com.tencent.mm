package com.tencent.mm.svg.d;

import java.lang.reflect.Field;

public final class a
{
  private boolean btv;
  public Field btw;
  private String classname;
  private String fieldName;
  public Object obj;
  
  public a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("obj cannot be null");
    }
    obj = paramObject;
    fieldName = paramString;
    classname = null;
  }
  
  public final Object get()
  {
    prepare();
    if (btw == null) {
      throw new NoSuchFieldException();
    }
    try
    {
      Object localObject = btw.get(obj);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalArgumentException("unable to cast object");
    }
  }
  
  public final void prepare()
  {
    if (btv) {
      return;
    }
    btv = true;
    Class localClass = obj.getClass();
    while (localClass != null) {
      try
      {
        Field localField1 = localClass.getDeclaredField(fieldName);
        localField1.setAccessible(true);
        btw = localField1;
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if ((classname != null) && (!classname.equals("")))
            {
              Field[] arrayOfField = localClass.getDeclaredFields();
              int j = arrayOfField.length;
              i = 0;
              if (i < j)
              {
                Field localField2 = arrayOfField[i];
                if (!localField2.getType().getName().equals(classname)) {
                  continue;
                }
                localField2.setAccessible(true);
                btw = localField2;
              }
            }
          }
          catch (Exception localException2)
          {
            int i;
            continue;
          }
          localClass = localClass.getSuperclass();
          break;
          i += 1;
        }
      }
      finally
      {
        localClass.getSuperclass();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.svg.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */