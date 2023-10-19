
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }                   

class Usuario(
	val nome: String,
    val id: String
)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        
        if(inscritos.filter{it.id.contains(usuario.id)}.isNotEmpty()){
            println("Usuário ja cadastrado...!")
        }else{
            inscritos.add(usuario)
        }
    }
    
    fun imprimirIncrições(){
        println(conteudos)
    }
}

fun main() {
    
    val user_1: Usuario = Usuario("Tarcio Silva", "33")
    val user_2: Usuario = Usuario("Jaqueline Say", "30")
    val user_3: Usuario = Usuario("Tawane Silva", "1.5")
        
    val cont_1: ConteudoEducacional = ConteudoEducacional("Kotlin", 60, Nivel.INTERMEDIARIO)
    val cont_2: ConteudoEducacional = ConteudoEducacional("Java", 120, Nivel.DIFICIL)
    val cont_3: ConteudoEducacional = ConteudoEducacional("Python", 240, Nivel.BASICO)
    
    val conteudos = mutableListOf<ConteudoEducacional>()
    conteudos.add(cont_1)
    conteudos.add(cont_2)
    conteudos.add(cont_3)
    
    val formacaoMobile: Formacao = Formacao("Mobile Dev", conteudos)
    formacaoMobile.matricular(user_1)
    formacaoMobile.matricular(user_2)
    formacaoMobile.matricular(user_3) 
    
    formacaoMobile.matricular(user_1)
    
    formacaoMobile.imprimirIncrições()
}
