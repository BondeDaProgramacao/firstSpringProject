Segue alguns comandos git:

git checkout -b <branch> origin/<branch> --- checkout de novo branch a partir de um branch de origem( neste caso não olha remoto, o outro branch é local) 
git push origin [name_of_your_new_branch] --para subir o novo branch para o remote


git pull ---contata o branch origem remoto pra ver as diferenças
git status
git add . (adiciona todos os arquivos)
git commit -m "mensagem"
git push (sobe para o servidor remoto)
git clone -b <branch> <remote repo>

para sobreescrever os arquivos locais pelo remote:
git fetch --all    (copia os arquivos)
git reset --hard origin/master ou git reset --hard origin/<branch_name>    (passa por cima)