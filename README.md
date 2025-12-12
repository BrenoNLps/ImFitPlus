## 🙋‍♂️ Sobre o projeto  

Esse app foi desenvolvido como parte da disciplina **Programação para Dispositivos Móveis** no **IFSP - São Carlos**.  
O objetivo é aplicar conceitos de **Activities**, **Intents explícitas**, persistência local com **Room/SQLite** e boas práticas de programação em Kotlin.  

---

# 🏋️ ImFitPlus  
Aplicativo Android que calcula indicadores de saúde e mantém histórico de usuários com persistência local.  

![ImFitPlus](image/capa.png)  

---

## ✨ O que ele faz  

- Permite ao usuário cadastrar **dados pessoais**: Nome, Idade, Sexo, Altura, Peso e Nível de atividade  
- Calcula automaticamente:  
  - **IMC** (Índice de Massa Corporal)  
  - **Categoria do IMC** (Abaixo do peso, Normal, Sobrepeso, Obesidade)  
  - **TMB** (Taxa Metabólica Basal)  
  - **Peso Ideal**  
  - **Recomendação de água** (350ml por kg de peso corporal)  
- Armazena os dados e cálculos no banco local (SQLite/Room)  
- Exibe um **histórico de cálculos** em lista personalizada, permitindo identificar cada usuário e seus resultados  
- Possibilita **editar dados**: ao selecionar um usuário no histórico, os campos são preenchidos automaticamente para atualização  
- Navegação entre telas via **Intent explícita** com passagem de parâmetros  

---

## ⚙️ Tecnologias usadas  

- **Kotlin** — linguagem principal  
- **Android Studio** — ambiente de desenvolvimento  
- **Room (SQLite)** — persistência local de dados  
- **Intents explícitas** — para navegação e passagem de dados  
- **ViewBinding** — para facilitar a ligação entre layout e código  
- **RecyclerView** — para exibir o histórico de cálculos  

---

## 📂 Estrutura básica  

- `MainActivity.kt`  
  - Tela inicial com opções de cadastro e histórico  

- `DadosPessoais.kt`  
  - Formulário para inserir/editar dados pessoais  
  - Validação dos campos antes de prosseguir  

- `ResultadoIMC.kt`  
  - Exibe cálculos de IMC, categoria, TMB e peso ideal  

- `ResumoSaude.kt`  
  - Mostra resumo final com recomendação de água  
  - Persiste os dados no banco local  

- `HistoricoActivity.kt`  
  - Lista personalizada com todos os usuários e seus cálculos  
  - Botão **Editar** que recupera e preenche automaticamente os dados  

---

## 🧪 Como testar  

1. Clone o repositório:  
   ```bash
   git clone https://github.com/BrenoNLps/imfitplus.git
