package ru.gnkoshelev.demo.spring_angular.web.mongo;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.mongodb.morphia.converters.SimpleValueConverter;
import org.mongodb.morphia.converters.TypeConverter;
import org.mongodb.morphia.mapping.MappedField;
import org.mongodb.morphia.mapping.MappingException;

import java.util.Date;

/**
 * Created by kgn on 20.09.2015.
 */
public class DateTimeConverter extends TypeConverter implements SimpleValueConverter
{
    public DateTimeConverter()
    {
        super(DateTime.class);
    }

    @Override
    public Object decode(Class targetClass, Object fromDBObject, MappedField optionalExtraInfo) throws MappingException
    {
        Object result = null;
        if (fromDBObject != null)
        {
            Date date = (Date) fromDBObject;
            result = new DateTime(date.getTime(), DateTimeZone.UTC);
        }
        return result;
    }

    @Override
    public Object encode(Object value, MappedField optionalExtraInfo)
    {
        if (value == null) {
            return null;
        }
        DateTime dateTime = ((DateTime) value).toDateTime(DateTimeZone.UTC);
        return dateTime.toDate();
    }
}