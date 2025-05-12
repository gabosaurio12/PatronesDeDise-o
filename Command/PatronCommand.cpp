#include <iostream>
#include <list>
#include <string>

class Command
{
public:
    virtual ~Command() {}
    virtual void Execute() = 0;

protected:
    Command() {}
};

class Document
{
private:
    std::string _name;

public:
    Document(const std::string &name) : _name(name) {}

    void Open()
    {
        std::cout << "Documento '" << _name << "' abierto." << std::endl;
    }

    void Paste()
    {
        std::cout << "Pegando contenido en '" << _name << "'..." << std::endl;
    }
};

class Application
{
public:
    void Add(Document *doc)
    {
        std::cout << "Documento aniadido a la aplicacion." << std::endl;
    }
};

class OpenCommand : public Command
{
public:
    OpenCommand(Application *app) : _application(app) {}

    virtual void Execute() override
    {
        const char *name = AskUser();
        if (name != nullptr)
        {
            Document *document = new Document(name);
            _application->Add(document);
            document->Open();
        }
    }

protected:
    virtual const char *AskUser()
    {

        return "archivo.txt";
    }

private:
    Application *_application;
};

class PasteCommand : public Command
{
public:
    PasteCommand(Document *doc) : _document(doc) {}

    virtual void Execute() override
    {
        _document->Paste();
    }

private:
    Document *_document;
};

template <class Receiver>
class SimpleCommand : public Command
{
public:
    typedef void (Receiver::*Action)();

    SimpleCommand(Receiver *r, Action a) : _receiver(r), _action(a) {}

    virtual void Execute() override
    {
        (_receiver->*_action)();
    }

private:
    Receiver *_receiver;
    Action _action;
};

class MacroCommand : public Command
{
public:
    MacroCommand()
    {
        _cmds = new std::list<Command *>();
    }

    virtual ~MacroCommand()
    {
        delete _cmds;
    }

    virtual void Add(Command *c)
    {
        _cmds->push_back(c);
    }

    virtual void Remove(Command *c)
    {
        _cmds->remove(c);
    }

    virtual void Execute() override
    {
        for (auto c : *_cmds)
        {
            c->Execute();
        }
    }

private:
    std::list<Command *> *_cmds;
};

class MyClass
{
public:
    void Action()
    {
        std::cout << "Accion ejecutada desde MyClass::Action()." << std::endl;
    }
};

// ==== Función principal de prueba ====

int main()
{
    Application *app = new Application();
    Document *doc = new Document("informe.pdf");

    // OpenCommand
    Command *openCmd = new OpenCommand(app);
    openCmd->Execute();

    // PasteCommand
    Command *pasteCmd = new PasteCommand(doc);
    pasteCmd->Execute();

    // SimpleCommand
    MyClass *receiver = new MyClass();
    Command *simpleCmd = new SimpleCommand<MyClass>(receiver, &MyClass::Action);
    simpleCmd->Execute();

    // MacroCommand
    MacroCommand *macro = new MacroCommand();
    macro->Add(openCmd);
    macro->Add(pasteCmd);
    macro->Add(simpleCmd);

    std::cout << "--- Ejecutando macro ---" << std::endl;
    macro->Execute();

    delete openCmd;
    delete pasteCmd;
    delete simpleCmd;
    delete macro;
    delete app;
    delete doc;
    delete receiver;

    return 0;
}
