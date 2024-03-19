package ru.task;

/**
 * @author RuziyaBadrutdinova
 * @since 17.03.2024
 */
public class StringConverter {

    public <T> String convertObjects(String delimiter, T... objects) {
        objectsChecks(objects);
        int size = objects.length;
        if (size == 1) {
             return objects[0].toString();
        }
        StringBuilder returnString = new StringBuilder();
        if (size == 2) {
            return returnString.append(objects[0]).append(delimiter).append(objects[1]).toString();
        }
        for (int i = 0; i < size - 2; i++) {
            returnString.append(objects[i]).append(delimiter);
        }
        return returnString.append(objects[size-1]).toString();
    }

    private <T> void objectsChecks(T... objects) {
        if (objects.length == 0) {
            throw new EmptyStackException();
        }
        Class<?> objectClass = null;
        for (int i = 0; i < objects.length - 1; i++) {
            //if (Objects.isNull(objects[i])) { java 1.8
            if (objects[i] == null) {
                throw new NullPointerException("Параметр под индексом " + i + " равен null!");
            }
            if (objectClass == null) {
                objectClass = objects[0].getClass();
            }
            if (!objectClass.equals(objects[i].getClass())) {
                throw new IllegalArgumentException("Объекты имеют разные типы!");
            }
            if (objects[i] instanceof String && (((String) objects[i]).isEmpty() || ((String) objects[i]).contains(" "))) { // ((String) objects[i]).isBlank() с 11 версии
                throw new IllegalArgumentException("Один из параметров является пустой строкой или символом пробела!");
            }
        }
    }
}
