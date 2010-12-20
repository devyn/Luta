require 'buildr/scala'

repositories.remote << 'http://www.ibiblio.org/maven2/'

define 'luta' do
  project.version = '0'
  package( :jar ).with :manifest => { 'Main-Class' => 'devyn.luta.Main' }
  run.using :main => "devyn.luta.Main"
end
