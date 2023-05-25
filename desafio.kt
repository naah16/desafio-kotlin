enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado em $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado em $nome.")
        }
    }

    fun listarInscritos() {
        println("Usuários inscritos em $nome:")
        for (usuario in inscritos) {
            println(usuario.nome)
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Algoritmos Avançados", 180)
    val conteudo3 = ConteudoEducacional("Estruturas de Dados", 150)

    val formacao = Formacao("Formação em Programação", listOf(conteudo1, conteudo2, conteudo3))

    val usuario1 = Usuario("Thiago")
    val usuario2 = Usuario("Jaque")
    val usuario3 = Usuario("Fernando")

    formacao.matricular(usuario1) // Usuário João matriculado na formação Formação em Programação.
    formacao.matricular(usuario2) // Usuário Maria matriculado na formação Formação em Programação.
    formacao.matricular(usuario1) // Usuário João já está matriculado na formação Formação em Programação.
    formacao.matricular(usuario3) // Usuário Pedro matriculado na formação Formação em Programação.

    formacao.listarInscritos()
}
