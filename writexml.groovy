def manifestFile = new File('AndroidManifest.xml')
def ns = new groovy.xml.Namespace('http://schemas.android.com/apk/res/android', 'ns')
def parser = new groovy.util.XmlParser(false, true)
def rootNode = parser.parse(manifestFile)
def attributes = rootNode.attributes()
def versionNumber = attributes[ns.versionCode]
versionNumber++
attributes[ns.versionCode] = versionNumber
//attributes[ns.versionName] = "${project.version}"

def writer = new groovy.io.GroovyPrintWriter(manifestFile)
writer.println('<?xml version="1.0" encoding="UTF-8"?>')
def xmlWriter = new groovy.util.XmlNodePrinter(writer)
xmlWriter.setExpandEmptyElements(true)
xmlWriter.setPreserveWhitespace(true)
xmlWriter.setNamespaceAware(true)
xmlWriter.print(rootNode)

// TODO: try to print the same format of the XML file, with the following code
import groovy.xml.XmlUtil
//import groovy.xml.StreamingMarkupBuilder
//manifestFile.withWriter { outWriter ->
//    XmlUtil.serialize( new StreamingMarkupBuilder().bind{ mkp.yield rootNode }, outWriter )
//}
println( XmlUtil.serialize( rootNode ) )
