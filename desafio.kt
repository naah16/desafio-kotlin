enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Aluno(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
        for (aluno in alunos) {
            if (!inscritos.contains(aluno)) {
                inscritos.add(aluno)
                println("Aluno ${aluno.nome} matriculado em $nome.")
            } else {
                println("Aluno ${aluno.nome} já está matriculado em $nome.")
            }
        }
    }

    fun listarInscritos() {
        println("Alunos inscritos na formação $nome:")
        for (aluno in inscritos) {
            println(aluno.nome)
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Algoritmos Avançados", 180)
    val conteudo3 = ConteudoEducacional("Estruturas de Dados", 150)

    val formacao = Formacao("Formação em Desenvolvimento Web", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2, conteudo3))

    val aluno1 = Aluno("Thiago")
    val aluno2 = Aluno("Naarah")
    val aluno3 = Aluno("Fernando")

    formacao.matricular(aluno1) 
    formacao.matricular(aluno2) 
    formacao.matricular(aluno1) 
    formacao.matricular(aluno3) 

    formacao.listarInscritos()
}
