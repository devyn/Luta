require 'buildr/scala'
require 'rbconfig'

repositories.remote << 'http://www.ibiblio.org/maven2/'
repositories.remote << 'http://lwjgl-maven.googlecode.com/svn/trunk/repository/'
repositories.remote << 'http://slick.cokeandcode.com/mavenrepo/'

case h = Config::CONFIG['host_os']
when /mswin|mingw/
  NatPath = File.join(File.dirname(__FILE__), "ext/win32")
else
  NatPath = File.join(File.dirname(__FILE__), "ext", h.downcase)
end

define 'luta' do
  project.version = '0'

  compile.with "org.lwjgl:lwjgl:jar:2.6"
  compile.with "slick:slick:jar:274"

  package( :jar ).with :manifest => { 'Main-Class' => 'devyn.luta.Main' }

  run.using( :main      => "devyn.luta.Main",
             :java_args => ["-Djava.library.path=#{NatPath}"] )
end
