require 'buildr/scala'

repositories.remote << 'http://www.ibiblio.org/maven2/'
repositories.remote << 'http://slick.cokeandcode.com/mavenrepo/'

define 'luta' do
  project.version = '0'
  compile.with "slick:slick:jar:274"
  package( :jar ).with :manifest => { 'Main-Class' => 'devyn.luta.Main' }
  run.using :main => "devyn.luta.Main"
end
