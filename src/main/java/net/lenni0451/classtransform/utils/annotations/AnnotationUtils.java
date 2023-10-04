package net.lenni0451.classtransform.utils.annotations;

import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

import static net.lenni0451.classtransform.utils.Types.typeDescriptor;

@ParametersAreNonnullByDefault
public class AnnotationUtils {

    /**
     * Convert a list of key-value pairs to a map.<br>
     * The list must be in the format {@code [key, value, key, value, ...]}.
     *
     * @param list The list to convert
     * @return The converted map
     * @throws IndexOutOfBoundsException If the size of the list is not even
     * @throws ClassCastException        If the key is not a string
     */
    public static Map<String, Object> listToMap(@Nullable final List<Object> list) {
        Map<String, Object> map = new HashMap<>();
        if (list != null) {
            for (int i = 0; i < list.size(); i += 2) map.put((String) list.get(i), list.get(i + 1));
        }
        return map;
    }

    /**
     * Convert a map to a list of key-value pairs.<br>
     * The list will be in the format {@code [key, value, key, value, ...]}.
     *
     * @param map The map to convert
     * @return The converted list
     */
    public static List<Object> mapToList(@Nullable final Map<String, Object> map) {
        List<Object> list = new ArrayList<>();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                list.add(entry.getKey());
                list.add(entry.getValue());
            }
        }
        return list;
    }

    /**
     * Find a visible annotation in a {@link ClassNode}.
     *
     * @param classNode       The class node to search in
     * @param annotationClass The annotation class to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findVisibleAnnotation(final ClassNode classNode, final Class<?> annotationClass) {
        return findAnnotation(classNode.visibleAnnotations, annotationClass);
    }

    /**
     * Find a visible annotation in a {@link ClassNode}.
     *
     * @param classNode            The class node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findVisibleAnnotation(final ClassNode classNode, final String annotationDescriptor) {
        return findAnnotation(classNode.visibleAnnotations, annotationDescriptor);
    }

    /**
     * Find a visible annotation in a {@link FieldNode}.
     *
     * @param fieldNode       The field node to search in
     * @param annotationClass The annotation class to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findVisibleAnnotation(final FieldNode fieldNode, final Class<?> annotationClass) {
        return findAnnotation(fieldNode.visibleAnnotations, annotationClass);
    }

    /**
     * Find a visible annotation in a {@link FieldNode}.
     *
     * @param fieldNode            The field node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findVisibleAnnotation(final FieldNode fieldNode, final String annotationDescriptor) {
        return findAnnotation(fieldNode.visibleAnnotations, annotationDescriptor);
    }

    /**
     * Find a visible annotation in a {@link MethodNode}.
     *
     * @param methodNode      The method node to search in
     * @param annotationClass The annotation class to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findVisibleAnnotation(final MethodNode methodNode, final Class<?> annotationClass) {
        return findAnnotation(methodNode.visibleAnnotations, annotationClass);
    }

    /**
     * Find a visible annotation in a {@link MethodNode}.
     *
     * @param methodNode           The method node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findVisibleAnnotation(final MethodNode methodNode, final String annotationDescriptor) {
        return findAnnotation(methodNode.visibleAnnotations, annotationDescriptor);
    }


    /**
     * Find an invisible annotation in a {@link ClassNode}.
     *
     * @param classNode       The class node to search in
     * @param annotationClass The annotation class to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findInvisibleAnnotation(final ClassNode classNode, final Class<?> annotationClass) {
        return findAnnotation(classNode.invisibleAnnotations, annotationClass);
    }

    /**
     * Find an invisible annotation in a {@link ClassNode}.
     *
     * @param classNode            The class node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findInvisibleAnnotation(final ClassNode classNode, final String annotationDescriptor) {
        return findAnnotation(classNode.invisibleAnnotations, annotationDescriptor);
    }

    /**
     * Find an invisible annotation in a {@link FieldNode}.
     *
     * @param fieldNode       The field node to search in
     * @param annotationClass The annotation class to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findInvisibleAnnotation(final FieldNode fieldNode, final Class<?> annotationClass) {
        return findAnnotation(fieldNode.invisibleAnnotations, annotationClass);
    }

    /**
     * Find an invisible annotation in a {@link FieldNode}.
     *
     * @param fieldNode            The field node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findInvisibleAnnotation(final FieldNode fieldNode, final String annotationDescriptor) {
        return findAnnotation(fieldNode.invisibleAnnotations, annotationDescriptor);
    }

    /**
     * Find an invisible annotation in a {@link MethodNode}.
     *
     * @param methodNode      The method node to search in
     * @param annotationClass The annotation class to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findInvisibleAnnotation(final MethodNode methodNode, final Class<?> annotationClass) {
        return findAnnotation(methodNode.invisibleAnnotations, annotationClass);
    }

    /**
     * Find an invisible annotation in a {@link MethodNode}.
     *
     * @param methodNode           The method node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findInvisibleAnnotation(final MethodNode methodNode, final String annotationDescriptor) {
        return findAnnotation(methodNode.invisibleAnnotations, annotationDescriptor);
    }


    /**
     * Find a visible or invisible annotation in a {@link ClassNode}.
     *
     * @param classNode       The class node to search in
     * @param annotationClass The annotation class to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findAnnotation(final ClassNode classNode, final Class<?> annotationClass) {
        Optional<AnnotationNode> annotationNode = findVisibleAnnotation(classNode, annotationClass);
        if (annotationNode.isPresent()) return annotationNode;
        return findInvisibleAnnotation(classNode, annotationClass);
    }

    /**
     * Find a visible or invisible annotation in a {@link ClassNode}.
     *
     * @param classNode            The class node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findAnnotation(final ClassNode classNode, final String annotationDescriptor) {
        Optional<AnnotationNode> annotationNode = findVisibleAnnotation(classNode, annotationDescriptor);
        if (annotationNode.isPresent()) return annotationNode;
        return findInvisibleAnnotation(classNode, annotationDescriptor);
    }

    /**
     * Find a visible or invisible annotation in a {@link FieldNode}.
     *
     * @param fieldNode       The field node to search in
     * @param annotationClass The annotation class to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findAnnotation(final FieldNode fieldNode, final Class<?> annotationClass) {
        Optional<AnnotationNode> annotationNode = findVisibleAnnotation(fieldNode, annotationClass);
        if (annotationNode.isPresent()) return annotationNode;
        return findInvisibleAnnotation(fieldNode, annotationClass);
    }

    /**
     * Find a visible or invisible annotation in a {@link FieldNode}.
     *
     * @param fieldNode            The field node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findAnnotation(final FieldNode fieldNode, final String annotationDescriptor) {
        Optional<AnnotationNode> annotationNode = findVisibleAnnotation(fieldNode, annotationDescriptor);
        if (annotationNode.isPresent()) return annotationNode;
        return findInvisibleAnnotation(fieldNode, annotationDescriptor);
    }

    /**
     * Find a visible or invisible annotation in a {@link MethodNode}.
     *
     * @param methodNode      The method node to search in
     * @param annotationClass The annotation class to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findAnnotation(final MethodNode methodNode, final Class<?> annotationClass) {
        Optional<AnnotationNode> annotationNode = findVisibleAnnotation(methodNode, annotationClass);
        if (annotationNode.isPresent()) return annotationNode;
        return findInvisibleAnnotation(methodNode, annotationClass);
    }

    /**
     * Find a visible or invisible annotation in a {@link MethodNode}.
     *
     * @param methodNode           The method node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findAnnotation(final MethodNode methodNode, final String annotationDescriptor) {
        Optional<AnnotationNode> annotationNode = findVisibleAnnotation(methodNode, annotationDescriptor);
        if (annotationNode.isPresent()) return annotationNode;
        return findInvisibleAnnotation(methodNode, annotationDescriptor);
    }

    /**
     * Find an annotation in a list of annotations.
     *
     * @param annotations     The list of annotations to search in
     * @param annotationClass The annotation class to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findAnnotation(@Nullable final List<AnnotationNode> annotations, final Class<?> annotationClass) {
        return findAnnotation(annotations, typeDescriptor(annotationClass));
    }

    /**
     * Find an annotation in a list of annotations.
     *
     * @param annotations          The list of annotations to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return The annotation if found
     */
    public static Optional<AnnotationNode> findAnnotation(@Nullable final List<AnnotationNode> annotations, final String annotationDescriptor) {
        if (annotations == null) return Optional.empty();
        for (AnnotationNode annotation : annotations) {
            if (annotation.desc.equals(annotationDescriptor)) return Optional.of(annotation);
        }
        return Optional.empty();
    }


    /**
     * Check if a {@link ClassNode} has a visible annotation.
     *
     * @param classNode       The class node to search in
     * @param annotationClass The annotation class to search for
     * @return If the class node has the annotation
     */
    public static boolean hasVisibleAnnotation(final ClassNode classNode, final Class<?> annotationClass) {
        return findVisibleAnnotation(classNode, annotationClass).isPresent();
    }

    /**
     * Check if a {@link ClassNode} has a visible annotation.
     *
     * @param classNode            The class node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return If the class node has the annotation
     */
    public static boolean hasVisibleAnnotation(final ClassNode classNode, final String annotationDescriptor) {
        return findVisibleAnnotation(classNode, annotationDescriptor).isPresent();
    }

    /**
     * Check if a {@link FieldNode} has a visible annotation.
     *
     * @param fieldNode       The field node to search in
     * @param annotationClass The annotation class to search for
     * @return If the field node has the annotation
     */
    public static boolean hasVisibleAnnotation(final FieldNode fieldNode, final Class<?> annotationClass) {
        return findVisibleAnnotation(fieldNode, annotationClass).isPresent();
    }

    /**
     * Check if a {@link FieldNode} has a visible annotation.
     *
     * @param fieldNode            The field node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return If the field node has the annotation
     */
    public static boolean hasVisibleAnnotation(final FieldNode fieldNode, final String annotationDescriptor) {
        return findVisibleAnnotation(fieldNode, annotationDescriptor).isPresent();
    }

    /**
     * Check if a {@link MethodNode} has a visible annotation.
     *
     * @param methodNode      The method node to search in
     * @param annotationClass The annotation class to search for
     * @return If the method node has the annotation
     */
    public static boolean hasVisibleAnnotation(final MethodNode methodNode, final Class<?> annotationClass) {
        return findVisibleAnnotation(methodNode, annotationClass).isPresent();
    }

    /**
     * Check if a {@link MethodNode} has a visible annotation.
     *
     * @param methodNode           The method node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return If the method node has the annotation
     */
    public static boolean hasVisibleAnnotation(final MethodNode methodNode, final String annotationDescriptor) {
        return findVisibleAnnotation(methodNode, annotationDescriptor).isPresent();
    }


    /**
     * Check if a {@link ClassNode} has an invisible annotation.
     *
     * @param classNode       The class node to search in
     * @param annotationClass The annotation class to search for
     * @return If the class node has the annotation
     */
    public static boolean hasInvisibleAnnotation(final ClassNode classNode, final Class<?> annotationClass) {
        return findInvisibleAnnotation(classNode, annotationClass).isPresent();
    }

    /**
     * Check if a {@link ClassNode} has an invisible annotation.
     *
     * @param classNode            The class node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return If the class node has the annotation
     */
    public static boolean hasInvisibleAnnotation(final ClassNode classNode, final String annotationDescriptor) {
        return findInvisibleAnnotation(classNode, annotationDescriptor).isPresent();
    }

    /**
     * Check if a {@link FieldNode} has an invisible annotation.
     *
     * @param fieldNode       The field node to search in
     * @param annotationClass The annotation class to search for
     * @return If the field node has the annotation
     */
    public static boolean hasInvisibleAnnotation(final FieldNode fieldNode, final Class<?> annotationClass) {
        return findInvisibleAnnotation(fieldNode, annotationClass).isPresent();
    }

    /**
     * Check if a {@link FieldNode} has an invisible annotation.
     *
     * @param fieldNode            The field node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return If the field node has the annotation
     */
    public static boolean hasInvisibleAnnotation(final FieldNode fieldNode, final String annotationDescriptor) {
        return findInvisibleAnnotation(fieldNode, annotationDescriptor).isPresent();
    }

    /**
     * Check if a {@link MethodNode} has an invisible annotation.
     *
     * @param methodNode      The method node to search in
     * @param annotationClass The annotation class to search for
     * @return If the method node has the annotation
     */
    public static boolean hasInvisibleAnnotation(final MethodNode methodNode, final Class<?> annotationClass) {
        return findInvisibleAnnotation(methodNode, annotationClass).isPresent();
    }

    /**
     * Check if a {@link MethodNode} has an invisible annotation.
     *
     * @param methodNode           The method node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return If the method node has the annotation
     */
    public static boolean hasInvisibleAnnotation(final MethodNode methodNode, final String annotationDescriptor) {
        return findInvisibleAnnotation(methodNode, annotationDescriptor).isPresent();
    }


    /**
     * Check if a {@link ClassNode} has a visible or invisible annotation.
     *
     * @param classNode       The class node to search in
     * @param annotationClass The annotation class to search for
     * @return If the class node has the annotation
     */
    public static boolean hasAnnotation(final ClassNode classNode, final Class<?> annotationClass) {
        return findAnnotation(classNode, annotationClass).isPresent();
    }

    /**
     * Check if a {@link ClassNode} has a visible or invisible annotation.
     *
     * @param classNode            The class node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return If the class node has the annotation
     */
    public static boolean hasAnnotation(final ClassNode classNode, final String annotationDescriptor) {
        return findAnnotation(classNode, annotationDescriptor).isPresent();
    }

    /**
     * Check if a {@link FieldNode} has a visible or invisible annotation.
     *
     * @param fieldNode       The field node to search in
     * @param annotationClass The annotation class to search for
     * @return If the field node has the annotation
     */
    public static boolean hasAnnotation(final FieldNode fieldNode, final Class<?> annotationClass) {
        return findAnnotation(fieldNode, annotationClass).isPresent();
    }

    /**
     * Check if a {@link FieldNode} has a visible or invisible annotation.
     *
     * @param fieldNode            The field node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return If the field node has the annotation
     */
    public static boolean hasAnnotation(final FieldNode fieldNode, final String annotationDescriptor) {
        return findAnnotation(fieldNode, annotationDescriptor).isPresent();
    }

    /**
     * Check if a {@link MethodNode} has a visible or invisible annotation.
     *
     * @param methodNode      The method node to search in
     * @param annotationClass The annotation class to search for
     * @return If the method node has the annotation
     */
    public static boolean hasAnnotation(final MethodNode methodNode, final Class<?> annotationClass) {
        return findAnnotation(methodNode, annotationClass).isPresent();
    }

    /**
     * Check if a {@link MethodNode} has a visible or invisible annotation.
     *
     * @param methodNode           The method node to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return If the method node has the annotation
     */
    public static boolean hasAnnotation(final MethodNode methodNode, final String annotationDescriptor) {
        return findAnnotation(methodNode, annotationDescriptor).isPresent();
    }

    /**
     * Check if a list of annotations has an annotation.
     *
     * @param annotations     The list of annotations to search in
     * @param annotationClass The annotation class to search for
     * @return If the list of annotations has the annotation
     */
    public static boolean hasAnnotation(@Nullable final List<AnnotationNode> annotations, final Class<?> annotationClass) {
        return findAnnotation(annotations, annotationClass).isPresent();
    }

    /**
     * Check if a list of annotations has an annotation.
     *
     * @param annotations          The list of annotations to search in
     * @param annotationDescriptor The descriptor of the annotation to search for
     * @return If the list of annotations has the annotation
     */
    public static boolean hasAnnotation(@Nullable final List<AnnotationNode> annotations, final String annotationDescriptor) {
        return findAnnotation(annotations, annotationDescriptor).isPresent();
    }

}
