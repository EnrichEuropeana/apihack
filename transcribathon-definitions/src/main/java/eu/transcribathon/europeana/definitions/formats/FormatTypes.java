package eu.transcribathon.europeana.definitions.formats;

import eu.transcribathon.europeana.definitions.exception.UnsupportedFormatTypeException;

/**
 * Enumerates the formats
 * 
 */
public enum FormatTypes {
    json("json"), // default format
    xml("xml");

    private String extension;

    public String getExtention() {
        return extension;
    }

    FormatTypes(String extention) {
        this.extension = extention;
    }

    /**
     * This method selects format type by Format type name.
     * 
     * @param extension
     * @return The format type
     * @throws UnsupportedFormatTypeException
     */
    public static FormatTypes getByExtention(String extention) throws UnsupportedFormatTypeException {

        for (FormatTypes formatType : FormatTypes.values()) {
            if (formatType.getExtention().equalsIgnoreCase(extention))
                return formatType;
        }
        throw new UnsupportedFormatTypeException(extention);
    }

    /**
     * Get format type by name.
     * 
     * @param name
     * @return The FormatTypes field
     * @throws UnsupportedFormatTypeException
     */
    public static FormatTypes getByName(String name) throws UnsupportedFormatTypeException {

        for (FormatTypes formatType : FormatTypes.values()) {
            if (formatType.name().equalsIgnoreCase(name))
                return formatType;
        }
        throw new UnsupportedFormatTypeException(name);
    }

    /**
     * This method is used for format validation
     * 
     * @param formatType
     * @return true if exists
     */
    public static boolean contains(String formatType) {

        for (FormatTypes field : FormatTypes.values()) {
            if (field.getExtention().equalsIgnoreCase(formatType)) {
                return true;
            }
        }

        return false;
    }

}