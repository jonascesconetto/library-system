//package cesconetto.daepractica01.client;
//
//import cesconetto.daepractica01.server.dao.*;
//import cesconetto.daepractica01.server.entity.*;
//import cesconetto.daepractica01.server.service.AutorService;
//import cesconetto.daepractica01.server.service.EditorService;
//import cesconetto.daepractica01.server.service.PublicService;
//import cesconetto.daepractica01.server.service.RevisorService;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Date;
//import java.util.Scanner;
//
//@Component
//public class ClientMain {
//
//    ApplicationContext context;
//
//    public ClientMain(ApplicationContext context){
//        this.context = context;
//    }
//
//    public void userEditor(Editor editor){
//
//        // Service
//        EditorService editorService = (EditorService) context.getBean(EditorService.class);
//
//        // View
//        ClientMain clientMain = new ClientMain(context);
//
//        do{
//            System.out.println();
//            System.out.println("############## Editor ##############");
//
//            System.out.println("# Presione 1 para ver la cola de libros piendientes.");
//            //System.out.println("# Presione 2 para ver la lista de Libros aceptos.");
//            //System.out.println("# Presione 3 para ver la lista de libros rechazados.");
//            System.out.println("# Presione 0 para volver al menu.");
//            System.out.print("# Opção ->> ");
//            Scanner entrada = new Scanner(System.in);
//            char opcion = 0;
//
//            //validacion de datos
//            try{
//                opcion = entrada.nextLine().charAt(0);
//            }catch(Exception e){
//                System.out.println("Erro !!! \n --->> " + e.getClass());
//            }
//
//            //Tratamiento de las opciones
//            if(opcion == '1'){
//                System.out.println("# Cola de Libros piendientes");
//                Collection<Libro> libros = editorService.verColaLibrosPendientes();
//                for (Libro aux : libros) {
//                    System.out.println(
//                            "\n# CodLibro: " + aux.getCodLibro() +
//                                    "\n# Titulo: " + aux.getTitulo() +
//                                    "\n# Tematica: " + aux.getTematica() +
//                                    "\n# Status: " + aux.getStatus()
//                    );
//                }
//
//                System.out.println("\t# Presione 1 aceptar libro.");
//                System.out.println("\t# Presione 2 rechazar libro.");
//                System.out.println("\t# Presione 0 para volver");
//                System.out.print("\t# Opcion: ");
//                Scanner entrada2 = new Scanner(System.in);
//                char opcion2 = 0;
//
//                //validacion de datos
//                try{
//                    opcion2 = entrada2.nextLine().charAt(0);
//                }catch(Exception e){
//                    System.out.println("Erro !!! \n --->> " + e.getClass());
//                }
//
//                if(opcion2 == '1'){
//                    System.out.print("    # Informe cod. libro: ");
//                    int codLibroAcepto = entrada2.nextInt();
//                    editorService.aceptarLibro(codLibroAcepto);
//
//                }else if(opcion2 == '2'){
//                    System.out.print("    # Informe cod. libro: ");
//                    int codLibroRech = entrada2.nextInt();
//                    editorService.rechazarLibro(codLibroRech);
//                }else if(opcion2 == '0'){
//                    userEditor(editor);
//                }
//
//            }else if(opcion == '2'){
//                System.out.println("ver la lista de Libros aceptos.");
//                // Accion
//            }else if(opcion == '3'){
//                System.out.println("ver la lista de libros rechazados");
//                // Accion
//            }else if(opcion == '0') {
//                clientMain.menu();
//                // Accion
//            }
//        }while(true);
//    }
//
//    public void userRevisor(Revisor revisor){
//
//        // Service
//        RevisorService revisorService = (RevisorService) context.getBean(RevisorService.class);
//
//        // View
//        ClientMain clientMain = new ClientMain(context);
//
//        do{
//            System.out.println();
//            System.out.println("############## Revisor ##############");
//            System.out.println("# Presione 1 para ver la lista de libros pendientes.");
//            //System.out.println("# Presione 2 para ver historico de Revisiones.");
//            System.out.println("# Presione 0 para volver al menu.");
//            System.out.print("# Opção ->> ");
//            Scanner entrada = new Scanner(System.in);
//            char opcion = 0;
//
//            //validacion de datos
//            try{
//                opcion = entrada.nextLine().charAt(0);
//            }catch(Exception e){
//                System.out.println("Erro !!! \n --->> " + e.getClass());
//            }
//
//            //Tratamiento de las opciones
//            if(opcion == '1'){
//
//                System.out.println("# Cola de Libros piendientes");
//
//                Collection<LibroAvaliacion> libros = revisorService.verLibrosPendientesRevision(revisor.getCodUsuario());
//
//                for (LibroAvaliacion aux : libros) {
//                    System.out.println(
//                            "\n# CodLibro: " + aux.getLibro().getCodLibro() +
//                                    "\n# Titulo: " + aux.getLibro().getTitulo() +
//                                    "\n# Tematica: " + aux.getLibro().getTematica() +
//                                    "\n# Status: " + aux.getLibro().getStatus()
//                    );
//                }
//
//                System.out.println("\t # Presione 1 para revisar Libro.");
//                System.out.println("\t # Presione 0 para volver.");
//                System.out.print("\t # Opcion: ");
//                Scanner entrada2 = new Scanner(System.in);
//                char opcion2 = 0;
//
//                //validacion de datos
//                try{
//                    opcion2 = entrada2.nextLine().charAt(0);
//                }catch(Exception e){
//                    System.out.println("Erro !!! \n --->> " + e.getClass());
//                }
//                if(opcion2 == '1'){
//                    System.out.print("    # Informe cod. libro: ");
//                    int codLibroAcepto = entrada2.nextInt();
//                    System.out.print("    # Informe nota para el libro: ");
//                    Double nota = entrada2.nextDouble();
//                    revisorService.revisarLibro(codLibroAcepto, nota, revisor);
//                }else if (opcion2 == '0'){
//                    userRevisor(revisor);
//                }
//                // Accion
//            }else if(opcion == '2'){
//
//                // Accion
//            }else if(opcion == '4'){
//
//                // Accion
//            }else if(opcion == '0') {
//                clientMain.menu();
//            }
//        }while(true);
//    }
//
//    public void userAutor(Autor autor){
//
//        // Service
//        AutorService autorService = (AutorService) context.getBean(AutorService.class);
//
//        // View
//        ClientMain clientMain = new ClientMain(context);
//
//        do{
//            System.out.println();
//            System.out.println("############## Autor ##############");
//            //System.out.println("# Presione 1 para Atualizar dados de Usuario.");
//            System.out.println("# Presione 2 para ver libros subidos.");
//            System.out.println("# Presione 3 para subir Libro.");
//            System.out.println("# Presione 0 para volver al menu.");
//            System.out.print("# Opção ->> ");
//
//            Scanner entrada = new Scanner(System.in);
//            char opcion = 0;
//
//            //validacion de datos
//            try{
//                opcion = entrada.nextLine().charAt(0);
//            }catch(Exception e){
//                System.out.println("Erro !!! \n --->> " + e.getClass());
//            }
//
//            //Tratamiento de las opciones
//            if(opcion == '1'){
//                System.out.println("# None <...>");
//
//                //userAutorView.mostrarOpciones(context, autor);
//                // Accion
//
//            }else if(opcion == '2'){
//
//                if(autorService.getLibrosSubidosByAutor(autor.getCodUsuario()).size() > 0) {
//
//                    System.out.println("# Lista de Libros Subidos");
//                    // PRINT Libros
//                    Collection<Libro> libros = autorService.getLibrosSubidosByAutor(autor.getCodUsuario());
//                    for (Libro aux : libros) {
//                        System.out.println(
//                                "\n# CodLibro: " + aux.getCodLibro() +
//                                        "\n# Titulo: " + aux.getTitulo() +
//                                        "\n# Tematica: " + aux.getTematica() +
//                                        "\n# Status: " + aux.getStatus() +
//                                        "\n# Autor: " + aux.getAutor().getCodUsuario()
//                        );
//                    }
//
//                    //System.out.println("# Presione 3 para atualizar libro.");
//                    //System.out.println("# Presione 4 para remover libro.");
//                    System.out.println("\t# Presione 0 para volver");
//                    int optionIn = entrada.nextInt();
//
//                    if (optionIn == 0) {
//                        userAutor(autor);
//                    }
//
//                }else{
//                    System.out.println("# Lista vacia.");
//                    //userAutorView.mostrarOpciones(context, autor);
//                }
//
//            }else if(opcion == '3'){
//                System.out.println("# Subir libro");
//
//                System.out.print("# Titulo: ");
//                String titulo = entrada.nextLine();
//
//                System.out.print("# Tematica: ");
//                String tematica = entrada.nextLine();
//
//                Libro l = new Libro();
//                l.setTitulo(titulo);
//                l.setTematica(tematica);
//
//                autorService.subirLibro(l, autor);
//
//                userAutor(autor);
//
//            }else if(opcion == '0') {
//
//                clientMain.menu();
//            }
//        }while(true);
//    }
//
//    public void publicLogin(){
//
//        PublicService publicService = (PublicService) context.getBean(PublicService.class);
//
//        // View
//        ClientMain clientMain = new ClientMain(context);
//
//        // Criando objetos
//        RevisorDaoJpaMySQL revisorDaoJpaMySQL = (RevisorDaoJpaMySQL) context.getBean(RevisorDaoJpaMySQL.class);
//        AutorDaoJpaMySQL autorDaoJpaMySQL = (AutorDaoJpaMySQL) context.getBean(AutorDaoJpaMySQL.class);
//        EditorDaoJpaMySQL editorDaoJpaMySQL = (EditorDaoJpaMySQL) context.getBean(EditorDaoJpaMySQL.class);
//
//        do{
//            System.out.println("");
//            System.out.println("############## Login ##############");
//            System.out.print("# Usuario: ");
//            Scanner scannerUsuario = new Scanner(System.in);
//            String usuario = scannerUsuario.nextLine().toString();
//
//            System.out.print("# Contrasena: ");
//            Scanner scannerContrasena = new Scanner(System.in);
//            String contrasena = scannerContrasena.nextLine().toString();
//
//            Usuario a = publicService.loggin(usuario, contrasena);
//
//            if(a.getRoles().get(0).getRole().equals("autor")){
//                Autor autor = autorDaoJpaMySQL.getAutorByCod(a.getCodUsuario());
//                userAutor(autor);
//            }else{
//                if(a.getRoles().get(0).getRole().equals("revisor")){
//                    Revisor revisor = revisorDaoJpaMySQL.getRevisorByCod(a.getCodUsuario());
//                    userRevisor(revisor);
//                }else{
//                    if(a.getRoles().get(0).getRole().equals("editor")){
//                        Editor editor = editorDaoJpaMySQL.getEditorByCod(a.getCodUsuario());
//                        userEditor(editor);
//                    }else{
//                        if(a.getRoles().get(0).getRole().equals("autor") && a.getRoles().get(1).getRole().equals("revisor") ||
//                                a.getRoles().get(0).getRole().equals("revisor") && a.getRoles().get(1).getRole().equals("autor")){
//                            System.out.print("# Ingresar como: \n# 1: revisor o 2: autor: ");
//                            Scanner leitura = new Scanner(System.in);
//
//                            int tipoUser = leitura.nextInt();
//
//                            if(tipoUser == 1){
//                                Autor autor = autorDaoJpaMySQL.getAutorByCod(a.getCodUsuario());
//                                userAutor(autor);
//                            }else{
//                                if(tipoUser == 2){
//                                    Revisor revisor = revisorDaoJpaMySQL.getRevisorByCod(a.getCodUsuario());
//                                    userRevisor(revisor);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
//        }while(false);
//
//    }
//
//    public void publicRegister(){
//
//        ClientMain clientMain = new ClientMain(context);
//
//        PublicService publicService = (PublicService) context.getBean(PublicService.class);
//
//        do{
//            System.out.println();
//            System.out.println("############## Register ##############");
//            System.out.println("# Presione 1 para AUTOR.");
//            System.out.println("# Presione 2 para REVISOR.");
//            System.out.println("# Precione 0 para volver al menu !!!");
//            System.out.print("# Opção ->> ");
//
//            Scanner entrada2 = new Scanner(System.in);
//
//            char opcion2 = 0;
//
//            //validacion de datos
//            try{
//                opcion2 = entrada2.nextLine().charAt(0);
//                //System.out.println("O usuario digitou " + opcao);
//            }catch(Exception e){
//                System.out.println("Erro !!! \n --->> " + e.getClass());
//            }
//
//            //Tratamiento de las opciones
//            if(opcion2 == '1'){
//                System.out.println("Registro de AUTOR");
//
//                System.out.print("# Nombre: ");
//                String nombre = entrada2.nextLine();
//
//                System.out.print("# Apellido: ");
//                String apellido = entrada2.nextLine();
//
//                System.out.print("# Fecha de Nascimento: ");
//                String fechaNasc = entrada2.nextLine();
//
//                System.out.print("# E-mail: ");
//                String email = entrada2.nextLine();
//
//                System.out.print("# Nombre de Usuario: ");
//                String nombreUser = entrada2.nextLine();
//
//                System.out.print("# Contrasena: ");
//                String contrasena = entrada2.nextLine();
//
//                Usuario a = new Usuario();
//                a.setNombre(nombre);
//                a.setApellido(apellido);
//                a.setFechaNasc(new Date(fechaNasc));
//                a.setEmail(email);
//                a.setNombreUsuario(nombreUser);
//                a.setContrasena(contrasena);
//
//                publicService.insertUsuario(a, 1);
//
//                clientMain.menu();
//
//            }else if(opcion2 == '2'){
//                System.out.println("Registro de Revisor");
//
//                System.out.print("# Nombre: ");
//                String nombre = entrada2.nextLine();
//
//                System.out.print("# Apellido: ");
//                String apellido = entrada2.nextLine();
//
//                System.out.print("# Fecha de Nascimento: ");
//                String fechaNasc = entrada2.nextLine();
//
//                System.out.print("# E-mail: ");
//                String email = entrada2.nextLine();
//
//                System.out.print("# Nombre de Usuario: ");
//                String nombreUser = entrada2.nextLine();
//
//                System.out.print("# Contrasena: ");
//                String contrasena = entrada2.nextLine();
//
//                Usuario a = new Usuario();
//                a.setNombre(nombre);
//                a.setApellido(apellido);
//                a.setFechaNasc(new Date(fechaNasc));
//                a.setEmail(email);
//                a.setNombreUsuario(nombreUser);
//                a.setContrasena(contrasena);
//
//                publicService.insertUsuario(a, 2);
//
//                clientMain.menu();
//
//            }else if (opcion2 == '0'){
//                clientMain.menu();
//            }
//        }while(true);
//    }
//
//    public void menu() {
//
//        PublicService publicService = (PublicService) context.getBean(PublicService.class);
//
//        // View
//        ClientMain clientMain = new ClientMain(context);
//
//        // Criando objetos
//        RevisorDaoJpaMySQL revisorDaoJpaMySQL = (RevisorDaoJpaMySQL) context.getBean(RevisorDaoJpaMySQL.class);
//        AutorDaoJpaMySQL autorDaoJpaMySQL = (AutorDaoJpaMySQL) context.getBean(AutorDaoJpaMySQL.class);
//        EditorDaoJpaMySQL editorDaoJpaMySQL = (EditorDaoJpaMySQL) context.getBean(EditorDaoJpaMySQL.class);
//
//        do {
//            System.out.println();
//            System.out.println("# Presione 1 para hacer login.");
//            System.out.println("# Presione 2 para registrar Usuario.");
//            System.out.println("# Qualquier otra para SALIR !!!");
//            System.out.print("# Opção ->> ");
//
//            Scanner entrada = new Scanner(System.in);
//
//            char opcion = 0;
//            // validacion de datos
//            try {
//                opcion = entrada.nextLine().charAt(0);
//                //System.out.println("O usuario digitou " + opcion);
//            } catch (Exception e) {
//                System.out.println("Erro !!! \n --->> " + e.getClass());
//            }
//
//            // Tratamiento de las opciones
//            if (opcion == '1') {
//                publicLogin();
//
//            } else if (opcion == '2') {
//                publicRegister();
//            } else {
//                System.exit(0);
//            }
//        } while(true);
//    }
//}