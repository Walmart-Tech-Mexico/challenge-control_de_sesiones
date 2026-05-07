public class Main {
    public static void main(String[] args) {
        // Reto para el desarrollador:
        // 1. Implementar la clase SesionManager de manera thread-safe.
        // 2. Añadir un método para obtener el número total de sesiones activas.
        // 3. Implementar un sistema de timeout para las sesiones inactivas (opcional).
        System.out.println("Reto: Gestión de Sesiones de Usuario");

        // Ejemplo de uso (puede ser modificado para probar la implementación)
        SesionManager.iniciarSesion("Usuario1");
        SesionManager.iniciarSesion("Usuario2");

        System.out.println("Sesiones activas: " + SesionManager.getSesionesActivas());
        System.out.println("Total de sesiones activas: " + SesionManager.getTotalSesionesActivas());

        SesionManager.cerrarSesion("Usuario1");

        System.out.println("Sesiones activas después de cerrar sesión: " + SesionManager.getSesionesActivas());
        System.out.println("Total de sesiones activas: " + SesionManager.getTotalSesionesActivas());
    }
}

class SesionManager {
    private static java.util.Set<String> sesionesActivas = new java.util.HashSet<>();

    public static void iniciarSesion(String usuario) {
        // TODO: Implementar de forma thread-safe
        sesionesActivas.add(usuario);
        System.out.println("Sesión iniciada para: " + usuario);
    }

    public static void cerrarSesion(String usuario) {
        // TODO: Implementar de forma thread-safe
        sesionesActivas.remove(usuario);
        System.out.println("Sesión cerrada para: " + usuario);
    }

    public static java.util.Set<String> getSesionesActivas() {
        // TODO: Implementar de forma thread-safe y devolver una copia
        return new java.util.HashSet<>(sesionesActivas);
    }

    public static int getTotalSesionesActivas() {
        // TODO: Implementar de forma thread-safe
        return sesionesActivas.size();
    }

    // TODO (Opcional): Implementar sistema de timeout para sesiones inactivas